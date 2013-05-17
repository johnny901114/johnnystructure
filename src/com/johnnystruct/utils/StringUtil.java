package com.johnnystruct.utils;


public class StringUtil {

	/**
	 * 截取boundary之前的字符串
	 * 
	 * @param source
	 * @param boundary
	 * @return
	 */
	public static String subString(String source, String boundary) {
		int i = source.lastIndexOf(boundary);
		if (i != -1) {
			return source.substring(0, i);
		}
		return source;
	}

	/**
	 * 替换换行符
	 * 
	 * @param source
	 * @return
	 */
	public static String replaceLineBreak(String source) {
		return source.replaceAll("[\\t\\n\\r]", "");
	}

}
