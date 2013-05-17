package com.johnnystruct.callback;

import com.johnnystruct.bean.TaskResult;

/**
 * 用于DAO层和Engine(服务层)的通信
 * 
 * @author YuZhiQiang
 * @createTime 2012.11.28
 * 
 */
public interface IRequestCallBack {

	/**
	 * 请求前
	 * 
	 * @param index
	 *            requestIndex
	 */
	public void preRequest(int index);

	/**
	 * 对返回的数据进行处理(一般主要对JSON/XML进行解析/对Cursor进行处理)
	 * 
	 * @param index
	 *            requestIndex
	 * @param data
	 *            需要处理的数据
	 * @return 数据处理后封装成对象
	 */
	public Object handleResult(int index, Object data);

	/**
	 * 请求后
	 * 
	 * @param index
	 * @param code
	 *            请求返回码
	 * @param result
	 *            请求后返回的结果
	 */
	public void postRequest(int index, TaskResult result) throws Exception;

}
