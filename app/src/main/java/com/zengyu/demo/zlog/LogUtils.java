package com.zengyu.demo.zlog;

import android.util.Log;

import com.zengyu.wheel.utils.ZLogHelper;

public class LogUtils {
    public static void e(String tag, String msg) {
        // use 2 to locate where call this method
        Log.e(tag, ZLogHelper.wrapMessage(2, msg));
    }
}
