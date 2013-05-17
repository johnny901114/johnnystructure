package com.johnnystruct.utils;

import android.app.Application;
import android.widget.Toast;

/**
 * Toast工具类
 * 
 * @author YZQ
 * 
 */
public class ToastUtil {

	private static Toast toast;

	public static void showToast(Application context, int resId) {
		if (toast == null) {
			toast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
		} else {
			toast.setText(resId);
		}
		toast.show();
	}

	public static void showToast(Application context, String msg) {
		if (toast == null) {
			toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
		} else {
			toast.setText(msg);
		}
		toast.show();
	}

	public static void hideToast() {
		if (toast != null) {
			toast.cancel();
			toast = null;
		}
	}
}
