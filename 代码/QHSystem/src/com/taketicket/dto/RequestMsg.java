package com.taketicket.dto;

import java.io.Serializable;

/*
 * ����ǿͻ��˴��ݸ�����������Ϣ����
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
