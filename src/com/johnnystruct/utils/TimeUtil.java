package com.johnnystruct.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Time util
 * 
 * @author YuZhiQiang
 */
public class TimeUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH mm ss", Locale.CHINA);

	/**
	 * @param millisecond
	 * @return
	 */
	public static String getCustomTime(long millisecond) {
		String timeStr = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(millisecond));
		calendar.setTimeZone(TimeZone.getDefault());
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		// 当前的日期
		int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		if (currentDay == day) {
			sdf.applyPattern("HH:mm");
			timeStr = "今天 " + sdf.format(new Date(millisecond));
		} else if (currentDay - day == 1) {
			sdf.applyPattern("HH:mm");
			timeStr = "昨天 " + sdf.format(new Date(millisecond));
		} else if (currentDay - day == 2) {
			sdf.applyPattern("HH:mm");
			timeStr = "前天 " + sdf.format(new Date(millisecond));
		} else {
			sdf.applyPattern("yyyy-MM-dd");
			timeStr = sdf.format(new Date(millisecond));
		}
		return timeStr;
	}

	/**
	 * 
	 * @return
	 */
	public static String getHMTime(long second) {
		sdf.applyPattern("HH:mm");
		return sdf.format(new Date(second * 1000));
	}

	/**
	 * 
	 * @param millisecond
	 * @return
	 */
	public static String getCustomTime4Chat(long millisecond) {
		String timeStr = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(millisecond));
		calendar.setTimeZone(TimeZone.getDefault());
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		// 当前的日期
		int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		if (currentDay == day) {
			timeStr = "今天 " + getTimeSlice(millisecond);
		} else if (currentDay - day == 1) {
			timeStr = "昨天 " + getTimeSlice(millisecond);
		} else if (currentDay - day == 2) {
			timeStr = "前天 " + getTimeSlice(millisecond);
		} else {
			sdf.applyPattern("yyyy-MM-dd");
			timeStr = sdf.format(new Date(millisecond));
		}
		return timeStr;
	}

	/**
	 * 
	 * @param timeStamp
	 *            MilliS
	 * @return
	 */
	private static String getTimeSlice(long timeStamp) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(timeStamp));
		calendar.setTimeZone(TimeZone.getDefault());
		int h = calendar.get(Calendar.HOUR_OF_DAY);
		if (h <= 7) {// 0:00-7:59 早晨
			return "早晨";
		} else if (h <= 11) {// 8:00-11:59
			return "上午";
		} else if (h <= 18) {// 12:00-18:59
			return "下午";
		} else {// 19:00-23:59
			return "晚上";
		}
	}
}
