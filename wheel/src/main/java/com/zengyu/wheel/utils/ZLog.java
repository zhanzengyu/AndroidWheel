package com.zengyu.wheel.utils;

import android.text.TextUtils;
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

    private static boolean isLinkMode = true;
    public static void setLinkMode(boolean linkMode) {
        isLinkMode = linkMode;
    }

    private static String tag = "ZLOG";
    public static void setTag(String tag) {
        if (!TextUtils.isEmpty(tag)) {
            ZLog.tag = tag;
        }
    }

    private static final int CALL_STACK_INDEX = 3;

    public static int v(String tag, String msg) {
        return isDebugMode ? Log.v(mapTag(tag), mapMsg(msg)) : -1;
    }

    public static int v(String msg) {
        return isDebugMode ? Log.v(tag, mapMsg(msg)) : -1;
    }

    public static int d(String tag, String msg) {
        return isDebugMode ? Log.d(mapTag(tag), mapMsg(msg)) : -1;
    }

    public static int d(String msg) {
        return isDebugMode ? Log.d(tag, mapMsg(msg)) : -1;
    }

    public static int i(String tag, String msg) {
        return isDebugMode ? Log.i(mapTag(tag), mapMsg(msg)) : -1;
    }

    public static int i(String msg) {
        return isDebugMode ? Log.i(tag, mapMsg(msg)) : -1;
    }

    public static int w(String tag, String msg) {
        return isDebugMode ? Log.w(mapTag(tag), mapMsg(msg)) : -1;
    }

    public static int w(String msg) {
        return isDebugMode ? Log.w(tag, mapMsg(msg)) : -1;
    }

    public static int e(String tag, String msg) {
        return isDebugMode ? Log.e(mapTag(tag), mapMsg(msg)) : -1;
    }

    public static int e(String msg) {
        return isDebugMode ? Log.e(tag, mapMsg(msg)) : -1;
    }

    private static String mapMsg(String msg) {
        return isLinkMode ? ZLogHelper.wrapMessage(CALL_STACK_INDEX, msg) : msg;
    }

    private static String mapTag(String tag) {
        return TextUtils.isEmpty(tag) ? ZLog.tag : tag;
    }
}
