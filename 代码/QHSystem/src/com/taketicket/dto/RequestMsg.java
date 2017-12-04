package com.taketicket.dto;

import java.io.Serializable;

/*
 * 解决是客户端传递给服务器的消息对象
 */
public class RequestMsg<T> implements Serializable {
	private int request;
	private T obj;

	public int getRequest() {
		return this.request;
	}

	public void setRequest(int request) {
		this.request = request;
	}

	public T getObj() {
		return this.obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

}
