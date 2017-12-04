package com.taketicket.entity;

import java.io.Serializable;

public class Window implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int num;
	private int business_id;
	private int disabled;

	public Window() {
	}

	public Window(int num, int business_id, int disabled) {
		this.num = num;
		this.business_id = business_id;
		this.disabled = disabled;
	}

	public Window(int id, int num, int business_id, int disabled) {

		this.id = id;
		this.num = num;
		this.business_id = business_id;
		this.disabled = disabled;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getBusiness_id() {
		return this.business_id;
	}

	public void setBusiness_id(int business_id) {
		this.business_id = business_id;
	}

	public int getDisabled() {
		return this.disabled;
	}

	public void setDisabled(int disabled) {
		this.disabled = disabled;
	}

}
