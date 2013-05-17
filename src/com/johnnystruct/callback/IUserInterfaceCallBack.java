package com.johnnystruct.callback;

import com.johnnystruct.bean.TaskResult;

/**
 * 用于界面(activity)和engine(服务层)的通讯
 * 
 * @author YuZhiQiang
 * @createTime 2012.11.28
 * 
 */
public interface IUserInterfaceCallBack {

	/**
	 * 获取数据前
	 * 
	 * @param index
	 *            requestIndex
	 */
	public void before(int index);

	/**
	 * 获取数据后
	 * 
	 * @param index
	 * @param result
	 *            请求后返回的结果
	 */
	public void after(int index, TaskResult result) throws Exception;
}
