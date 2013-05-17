package com.johnnystruct.engine;

import com.johnnystruct.bean.TaskResult;
import com.johnnystruct.callback.IRequestCallBack;

public abstract class BaseEngine implements IRequestCallBack {

	@Override
	public void preRequest(int index) {

	}

	@Override
	public Object handleResult(int index, Object data) {
		// handle data code
		// if(){
		// handlerRightCode
		// }else{
		// handlerWrongCode
		// }
		return data;
	}

	@Override
	public void postRequest(int index, TaskResult result) throws Exception {

	}

	public abstract void handlerWrongCode(int index, TaskResult baseBean);

	public abstract void handlerRightCode(int index, TaskResult baseBean);
}
