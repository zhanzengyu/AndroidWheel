package com.zengyu.wheel.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 2019-10-28
 *
 * @author Zengyu.Zhan
 */
public class ZLogHelper {
    private static final int CALL_STACK_INDEX = 1;
    private static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");

    public static String wrapMessage(int stackIndex, String message) {
        // DO NOT switch this to Thread.getCurrentThread().getStackTrace().
        if (stackIndex < 0) {
            stackIndex = CALL_STACK_INDEX;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length <= stackIndex) {
            throw new IllegalStateException(
                    "Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }
        String clazz = extractClassName(stackTrace[stackIndex]);
        int lineNumber = stackTrace[stackIndex].getLineNumber();
        message = "(" + clazz + ".java:" + lineNumber + ") - " + message;
        return message;
    }

    /**
     * Extract the class name without any anonymous class suffixes (e.g., {@code Foo$1}
     * becomes {@code Foo}).
     */
    private static String extractClassName(StackTraceElement element) {
        String tag = element.getClassName();
        Matcher m = ANONYMOUS_CLASS.matcher(tag);
        if (m.find()) {
            tag = m.replaceAll("");
        }
        return tag.substring(tag.lastIndexOf('.') + 1);
    }
}
