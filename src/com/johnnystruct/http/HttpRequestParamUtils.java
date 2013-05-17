package com.johnnystruct.http;

import java.io.Serializable;

/**
 * 请求参数拼接
 * 
 * @author YZQ
 * 
 */
public class HttpRequestParamUtils {

	private StringBuilder stringBuilder = new StringBuilder(100);
	/** add方法调用的次数 */
	private int addInvokeCount;
	public String baseUrl;

	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * @param baseUrl
	 *            如果需要拼接出http://www.baidu.com?id=1样的Url, http://www.baidu.
	 *            com就是baseUrl
	 */
	public HttpRequestParamUtils(String baseUrl) {
		this.baseUrl = baseUrl;
		stringBuilder.append(baseUrl);
	}

	/**
	 * 获取拼接后的完整Url.<br/>
	 * 如果需要每个URL需要加上一些固定的参数,可以接着在这里拼接,建议一些比较复杂的计算应该放在子线程中执行,例如接口加密的算法
	 * 
	 * @return
	 */
	public String getUrl() {
		return stringBuilder.toString();
	}

	/**
	 * 得到拼接的参数不包括baseUrl,如果没有参数直接返回null
	 * 
	 * @return
	 */
	public String getParams() {
		String completeUrl = getUrl();
		int index = completeUrl.indexOf('?');
		if (index != -1) {
			return completeUrl.substring(index + 1);
		}
		return null;
	}

	/**
	 * 往baseUrl里拼接参数.如需要拼接出http://www.baidu.com?id=1样的Url 可以调用该方法例如：add("id",1);
	 * 
	 * @param key
	 * @param value
	 */
	public void add(String key, Serializable value) {
		if (addInvokeCount == 0) {
			stringBuilder.append("?");
		} else {
			stringBuilder.append("&");
		}
		stringBuilder.append(key).append("=")
				.append(value == null ? "" : value);
		addInvokeCount++;
	}
}
