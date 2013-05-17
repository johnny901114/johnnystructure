package com.johnnystruct;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.johnnystruct.bean.RequestStatus;
import com.johnnystruct.bean.TaskResult;
import com.johnnystruct.callback.IUserInterfaceCallBack;

/**
 * Activity的基类
 * 
 * @author YZQ
 * 
 * 
 */
public abstract class BaseActivity extends Activity implements
		IUserInterfaceCallBack {
	protected Toast toast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void before(int index) {

	}

	@Override
	public void after(int index, TaskResult result) throws Exception {
		//
		handleRightJsonCode(index, result.data);
	}

	/**
	 * 处理网络错误
	 * 
	 * @param index
	 * @param code
	 */
	protected void handleNetError(int index, int code) {
		switch (code) {
		case RequestStatus.CODE_TASK_RESULT_CONNECT_TIMEOUT:
			showToast("网络连接超时");
			break;
		case RequestStatus.CODE_TASK_RESULT_SOCKET_TIMEOUT:
			showToast("网络连接超时");
			break;
		case RequestStatus.CODE_TASK_RESULT_FAILURE:
			showToast("网络不可用");
			break;
		}
	}

	/**
	 * 处理网络状态码为200(网络正确),但JSON状态码不为200的情况(服务器返回异常)
	 * 
	 * @param index
	 * @param obj
	 */
	private void handleWrongJsonCode(int index, Object obj) {

	}

	/**
	 * 处理JSON code为200(表示服务器返回正确)
	 */
	protected abstract void handleRightJsonCode(int index, Object data);

	/**
	 * Toast显示
	 * 
	 * @param msg
	 */
	protected void showToast(String msg) {
		if (toast == null) {
			toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
		} else {
			toast.setText(msg);
		}
		toast.show();
	}
}
