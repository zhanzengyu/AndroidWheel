package com.zengyu.wheel.utils

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.os.Build
import android.text.TextUtils
import android.util.Log
import java.lang.reflect.Method

object ProcessUtil {
    private val TAG: String = ProcessUtil.javaClass.simpleName

    /**
     * 这里依然是在主线程调用，还是可能出现 ANR 的，需要在子线程调用
     * 考虑到多进程的场景，所以不缓存 processName
     */
    fun getCurrentProcessName(context: Context, pid: Int): String? {
        // 1)通过 Application 的 API 获取当前进程名
        var currentProcessName = getCurrentProcessNameByApplication()
        if (!TextUtils.isEmpty(currentProcessName)) {
            Log.d(TAG, "getCurrentProcessNameByApplication")
            return currentProcessName
        }

        // 2) 通过反射 ActivityThread 获取当前进程名
        currentProcessName = getCurrentProcessNameByActivityThread()
        if (!TextUtils.isEmpty(currentProcessName)) {
            Log.d(TAG, "getCurrentProcessNameByActivityThread")
            return currentProcessName
        }

        // 3) 通过 ActivityManager 获取当前进程名
        currentProcessName = getCurrentProcessNameByActivityManager(context, pid)
        Log.d(TAG, "getCurrentProcessNameByActivityManager")

        return currentProcessName;
    }

    /**
     * 通过Application新的API获取进程名，无需反射，无需IPC，效率最高
     */
    private fun getCurrentProcessNameByApplication(): String? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) Application.getProcessName() else null
    }

    /**
     * 通过反射ActivityThread获取进程名，避免了ipc
     */
    @SuppressLint("DiscouragedPrivateApi", "PrivateApi")
    private fun getCurrentProcessNameByActivityThread(): String? {
        var processName: String? = null
        try {
            val declaredMethod: Method = Class.forName(
                "android.app.ActivityThread", false,
                Application::class.java.classLoader
            ).getDeclaredMethod("currentProcessName")
            declaredMethod.isAccessible = true
            val invoke: Any? = declaredMethod.invoke(null)
            if (invoke != null && invoke is String) {
                processName = invoke
            }
        } catch (e: Throwable) {
            Log.e(TAG, "reflect error:", e)
        }
        return processName
    }

    /**
     * 通过ActivityManager 获取进程名，需要IPC通信
     */
    private fun getCurrentProcessNameByActivityManager(context: Context, pid: Int): String? {
        val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val runningAppList = am.runningAppProcesses
        if (runningAppList != null) {
            for (processInfo in runningAppList) {
                if (processInfo.pid == pid) {
                    return processInfo.processName
                }
            }
        }
        return null
    }
}