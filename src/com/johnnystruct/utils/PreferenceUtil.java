package com.johnnystruct.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPrefereces工具类
 * 
 * @author YZQ
 * 
 */
public class PreferenceUtil {
	private static SharedPreferences sp;
	private static final String SP_NAME = "doctors_patient_online";

	private static PreferenceUtil preferenceUtil = new PreferenceUtil();

	private PreferenceUtil() {
	}

	public static PreferenceUtil getInstance(Application context) {
		sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
		return preferenceUtil;
	}

	public void putBoolean(String key, boolean value) {
		sp.edit().putBoolean(key, value).commit();
	}

	public void putString(String key, String value) {
		sp.edit().putString(key, value).commit();
	}

	public void putInt(String key, int value) {
		sp.edit().putInt(key, value).commit();
	}

	public void putFloat(String key, float value) {
		sp.edit().putFloat(key, value).commit();
	}

	public void putLong(String key, long value) {
		sp.edit().putLong(key, value).commit();
	}

	public String getString(String key,String defaultVaule) {
		return sp.getString(key, defaultVaule);
	}

	public long getLong(String key) {
		return sp.getLong(key, 0);
	}

	public boolean getBoolean(String key) {
		return sp.getBoolean(key, false);
	}

	public float getFloat(String key) {
		return sp.getFloat(key, 0);
	}

	public float getInt(String key) {
		return sp.getInt(key, -1);
	}
}
