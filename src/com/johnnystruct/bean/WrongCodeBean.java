package com.johnnystruct.bean;

/**
 * 网络请求正确但是返回的记过错误
 * 
 * @author yzq
 * 
 */
public class WrongCodeBean {
	/** 服务器返回的code */
	public int code;
	/** 服务器返回的错误信息 */
	public String msg;
	public String data;
}
