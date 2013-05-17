package com.johnnystruct.sample;

import com.johnnystruct.bean.TaskResult;
import com.johnnystruct.callback.IUserInterfaceCallBack;
import com.johnnystruct.engine.BaseEngine;
import com.johnnystruct.http.HttpRequestParamUtils;
import com.johnnystruct.http.SimpleHttpRequest;

public class TestEngine2 extends BaseEngine {
	private IUserInterfaceCallBack uiCallBack;

	public TestEngine2(IUserInterfaceCallBack uiCallBack) {
		this.uiCallBack = uiCallBack;
	}

	public void sendRequest() {
		SimpleHttpRequest request = new SimpleHttpRequest(this);
		// request.sendGetRequest("http://192.168.1.18:8080/TestServlet?para=1",
		// 1);
		HttpRequestParamUtils paramUtils = new HttpRequestParamUtils(
				"http://www.baidu.com");
		paramUtils.add("para", 1);
		request.sendPostRequest(paramUtils.getBaseUrl(), 1,
				paramUtils.getParams());
	}

	@Override
	public void preRequest(int index) {
		if (uiCallBack != null) {
			uiCallBack.before(index);
		}
	}

	@Override
	public void postRequest(int index, TaskResult result) throws Exception {
		if (uiCallBack != null) {
			uiCallBack.after(index, result);
		}
	}

	@Override
	public void handlerWrongCode(int index, TaskResult baseBean) {
		
	}

	@Override
	public void handlerRightCode(int index, TaskResult baseBean) {
		
	}
}
