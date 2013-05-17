package com.johnnystruct.task;

import java.io.ByteArrayOutputStream;

import android.text.TextUtils;
import com.johnnystruct.bean.RequestStatus;
import com.johnnystruct.bean.TaskResult;
import com.johnnystruct.callback.IRequestCallBack;
import com.johnnystruct.http.HttpConnect;

/**
 * HTTP网络请求任务 ,继承自{@link BaseAsyncTask},主要处理JSON格式的数据.<br>
 * 当调用execute()时param[0] is URL; param[1] is application(context).
 * 
 * @author YZQ
 * @createTime 2012.11.28
 * 
 */
public class HttpRequestTask extends BaseAsyncTask {
	private HttpConnect httpConnect = new HttpConnect();
	/** a HTTP response */
	// private HttpResponse response = null;
	/** 0 is get;1 is post */
	private int httpMethod = 0;
	public HttpRequestTask(IRequestCallBack requestCallBack, int index) {
		super(requestCallBack, index);
	}

	public HttpRequestTask(IRequestCallBack requestCallBack, int index,
			int httpMethod) {
		this(requestCallBack, index);
		this.httpMethod = httpMethod;
	}

	/**
	 * param[0] is URL; if requestMethod is post ,param[1] is parameter.
	 */
	@Override
	public TaskResult _doInBackground(Object... params) {
		if (params != null) {
			String url = (String) params[0];
			TaskResult result = new TaskResult();
			if (!TextUtils.isEmpty(url)) {
				int requestStatus = 0;
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				if (httpMethod == HttpConnect.GET) {
					// GET request
					requestStatus = httpConnect.sendGetRequest(url, baos);
				} else if (httpMethod == HttpConnect.POST) {
					// POST request
					String parameters = (String) params[1];
					requestStatus = httpConnect.sendPostRequest(url,
							parameters, baos);
				}
				if (requestStatus == RequestStatus.CODE_TASK_RESULT_SUCCESS) {// 网络状态码正常
					String data = new String(baos.toByteArray());
					if (!TextUtils.isEmpty(data)) {
						result.data = requestCallBack.handleResult(index, data);
					} else {
						result.statusMsg = "content is null";
					}
				} else {
					result.statusMsg = "statusCode is not 200";
				}
				result.statusCode = requestStatus;
				return result;
			}
		}
		return null;
	}
}
