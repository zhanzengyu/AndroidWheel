package com.zengyu.wheel.utils;

import android.util.Log;

/**
 * Created on 2019-10-26
 *
 * @author Zengyu.Zhan
 */
public class ZLog {
    private static boolean isDebugMode = false;
    public static void setDebugMode(boolean debugMode) {
        isDebugMode = debugMode;
    }

    public static int v(String tag, String msg) {
        return isDebugMode ? Log.v(tag, msg) : -1;
    }

    public static int d(String tag, String msg) {
        return isDebugMode ? Log.d(tag, msg) : -1;
    }

    public static int i(String tag, String msg) {
        return isDebugMode ? Log.i(tag, msg) : -1;
    }

    public static int w(String tag, String msg) {
        return isDebugMode ? Log.w(tag, msg) : -1;
    }

    public static int e(String tag, String msg) {
        return isDebugMode ? Log.e(tag, msg) : -1;
    }
}
