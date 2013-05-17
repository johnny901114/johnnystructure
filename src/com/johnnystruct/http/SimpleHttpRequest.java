package com.johnnystruct.http;

import com.johnnystruct.callback.IRequestCallBack;
import com.johnnystruct.task.HttpRequestTask;

/**
 * 一般的网络请求
 * 
 * @author YZQ
 */
public class SimpleHttpRequest {
	IRequestCallBack requestCallBack;

	public SimpleHttpRequest(IRequestCallBack requestCallBack) {
		this.requestCallBack = requestCallBack;
	}

	// http://192.168.1.18:8080/TestServlet?para=1
	private void sendRequest(String url, int index, int httpMethod,
			String parameters) {
		System.out.println("url====================>" + url);
		HttpRequestTask task = new HttpRequestTask(requestCallBack, index,
				httpMethod);
		task.execute(url, parameters);
	}

	/**
	 * 发送get请求
	 * 
	 * @param context
	 * @param url
	 * @param index
	 */
	public void sendGetRequest(String url, int index) {
		sendRequest(url, index, HttpConnect.GET, null);
	}

	/**
	 * 发送post请求,适合文件上传和传输比较大的string
	 * 
	 * @param context
	 * @param url
	 * @param index
	 *            request index
	 */
	public void sendPostRequest(String url, int index, String parameters) {
		sendRequest(url, index, HttpConnect.POST, parameters);
	}
}
