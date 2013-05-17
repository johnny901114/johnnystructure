package com.johnnystruct.task;

import android.os.AsyncTask;

import com.johnnystruct.bean.TaskResult;
import com.johnnystruct.callback.IRequestCallBack;

public abstract class BaseAsyncTask extends AsyncTask<Object, Void, TaskResult> {

	protected int index;
	protected IRequestCallBack requestCallBack;

	public BaseAsyncTask(IRequestCallBack requestCallBack, int index) {
		this.index = index;
		this.requestCallBack = requestCallBack;
	}

	@Override
	protected void onPostExecute(TaskResult result) {
		super.onPostExecute(result);
		TaskController.removeTaskFromContainer(index);
		try {
			requestCallBack.postRequest(index, result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			requestCallBack = null;
		}
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		TaskController.addTask2Container(index, this);
		requestCallBack.preRequest(index);
	}

	@Override
	protected TaskResult doInBackground(Object... params) {
		return _doInBackground(params);
	}

	public abstract TaskResult _doInBackground(Object... params);

}