package com.johnnystruct.bean;

public class RequestStatus {

	/** 任务失败 */
	public static final int CODE_TASK_RESULT_FAILURE = 1;
	/** 任务成功 */
	public static final int CODE_TASK_RESULT_SUCCESS = 2;
	/** 连接超时 */
	public static final int CODE_TASK_RESULT_CONNECT_TIMEOUT = 3;
	/** Socket超时 */
	public static final int CODE_TASK_RESULT_SOCKET_TIMEOUT = 4;
	/** 无效的URL */
	public static final int CODE_TASK_RESULT_INVALID_URL = 5;
}
