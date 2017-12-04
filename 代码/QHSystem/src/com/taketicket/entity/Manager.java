package com.taketicket.entity;

import java.io.Serializable;

public class Manager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String account;
	private String name;
	private String password;
	private int disabled;

	public Manager() {
	}

	public Manager(String account, String name, String password) {
		this.account = account;
		this.name = name;
		this.password = password;
	}

	public Manager(int id, String account, String name, String password) {
		this.id = id;
		this.account = account;
		this.name = name;
		this.password = password;
	}

	public Manager(int id, String account, String name, String password,
			int disabled) {
		this.id = id;
		this.account = account;
		this.name = name;
		this.password = password;
	}

	public int getdisabled() {

		return this.disabled;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
