package com.johnnystruct.utils;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

public class MenifestUtil {

	/**
	 * 获取程序版本名称
	 * 
	 * @param context
	 * @return
	 */
	public static String getVersionName(Application context) {
		try {
			PackageInfo pInfo = context.getPackageManager().getPackageInfo(
					context.getPackageName(), 0);
			return pInfo.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 获取程序包名
	 * 
	 * @param context
	 * @return
	 */
	public static String getAppPackage(Context context) {
		try {
			PackageInfo pInfo = context.getPackageManager().getPackageInfo(
					context.getPackageName(), 0);
			return pInfo.applicationInfo.packageName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
