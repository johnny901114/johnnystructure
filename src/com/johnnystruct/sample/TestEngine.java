package com.johnnystruct.sample;

import com.johnnystruct.bean.TaskResult;
import com.johnnystruct.callback.IRequestCallBack;
import com.johnnystruct.http.HttpRequestParamUtils;
import com.johnnystruct.http.SimpleHttpRequest;

public class TestEngine implements IRequestCallBack {

	public void sendRequest() {
		SimpleHttpRequest request = new SimpleHttpRequest(this);
		// request.sendGetRequest("http://192.168.1.18:8080/TestServlet?para=1",
		// 1);
		HttpRequestParamUtils paramUtils = new HttpRequestParamUtils(
				"http://192.168.1.18:8080/TestServlet");
		paramUtils.add("para", 1);
		request.sendPostRequest(paramUtils.getBaseUrl(), 1,
				paramUtils.getParams());
	}

	@Override
	public void preRequest(int index) {

	}

	@Override
	public Object handleResult(int index, Object data) {
		System.out.println("data:" + data);
		return data;
	}

	@Override
	public void postRequest(int index, TaskResult result) throws Exception {

	}


}
