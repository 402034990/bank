package com.taketicket.entity;

import java.io.Serializable;

public class Business implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String code;
	private String name;
	private int disabled;
	private int limitCount;

	public Business() {
	}

	public Business(String code, String name, int disabled, int limitCount) {
		this.code = code;
		this.name = name;
		this.disabled = disabled;
		this.limitCount = limitCount;
	}

	public Business(int id, String code, String name, int disabled,
			int limitCount) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.disabled = disabled;
		this.limitCount = limitCount;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDisabled() {
		return this.disabled;
	}

	public void setDisabled(int disabled) {
		this.disabled = disabled;
	}

	public int getLimitCount() {
		return this.limitCount;
	}

	public void setLimitCount(int limitCount) {
		this.limitCount = limitCount;
	}

}
