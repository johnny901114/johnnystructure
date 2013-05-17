package com.johnnystruct.utils;

import android.util.Log;

/**
 * Log工具类
 * 
 * @author YZQ
 * 
 */
public class LogUtil {

	private static final boolean logToggle = true;

	public static void info(String tag, String msg) {
		if (logToggle) {
			Log.i(tag, msg);
		}
	}

	public static void debug(String tag, String msg) {
		if (logToggle) {
			Log.d(tag, msg);
		}
	}

	public static void error(String tag, String msg) {
		if (logToggle) {
			Log.e(tag, msg);
		}
	}

	public static void warn(String tag, String msg) {
		if (logToggle) {
			Log.w(tag, msg);
		}
	}
}
