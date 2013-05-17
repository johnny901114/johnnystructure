package com.johnnystruct.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class InputMethodUtil {

	private static InputMethodManager inputMethodManager;

	/**
	 * 隐藏输入法
	 */
	public static void hideInputMethod(Activity context) {
		if (isOpen(context)) {
			inputMethodManager.hideSoftInputFromWindow(context
					.getCurrentFocus().getWindowToken(),
					InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	/**
	 * 判断输入法是否打开
	 * 
	 * @return
	 */
	public static boolean isOpen(Activity context) {
		initIMService(context);
		return inputMethodManager.isActive();
	}

	/**
	 * 显示系统默认的输入法
	 */
	public static void showInputMethod(Activity context, View view) {
		initIMService(context);
		inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_FORCED);
	}

	/**
	 * 输入法管理服务是否初始化
	 * 
	 * @param context
	 */
	private static void initIMService(Activity context) {
		if (inputMethodManager == null) {
			inputMethodManager = (InputMethodManager) context
					.getSystemService(Context.INPUT_METHOD_SERVICE);
		}
	}
}
