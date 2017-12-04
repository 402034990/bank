package com.taketicket.entity;

import java.io.Serializable;
import java.util.Date;

public class Ticket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int num;
	private int business_id;
	private Date takeDate;
	private int waitCount; // 可以被计算出来
	private String takeIp;
	private int caller_id;
	private int isCalled;
	private int isSuccess;
	private String caller_name;

	public Ticket() {
	}

	public Ticket(int num, int business_id, int caller_id, Date takeDate,
			int waitCount, String takeIp, int isCalled, int isSuccess,
			String caller_name) {
		this.num = num;
		this.business_id = business_id;
		this.takeDate = takeDate;
		this.waitCount = waitCount;
		this.takeIp = takeIp;
		this.isCalled = isCalled;
		this.isSuccess = isSuccess;
		this.caller_name = caller_name;
		this.caller_id = caller_id;
	}

	public Ticket(int id, int num, int business_id, int caller_id,
			Date takeDate, int waitCount, String takeIp, int isCalled,
			int isSuccess, String caller_name) {
		this.id = id;
		this.num = num;
		this.business_id = business_id;
		this.takeDate = takeDate;
		this.waitCount = waitCount;
		this.takeIp = takeIp;
		this.isCalled = isCalled;
		this.isSuccess = isSuccess;
		this.caller_name = caller_name;
		this.caller_id = caller_id;
	}

	public Ticket(int id, int num, int caller_id, int isSuccess,
			String caller_name) {
		this.id = id;
		this.num = num;
		this.isSuccess = isSuccess;
		this.caller_name = caller_name;
		this.caller_id = caller_id;
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

	public Date getTakeDate() {
		return this.takeDate;
	}

	public void setTakeDate(Date takeDate) {
		this.takeDate = takeDate;
	}

	public int getWaitCount() {
		return this.waitCount;
	}

	public void setWaitCount(int waitCount) {
		this.waitCount = waitCount;
	}

	public String getTakeIp() {
		return this.takeIp;
	}

	public void setTakeIp(String takeIp) {
		this.takeIp = takeIp;
	}

	public int getCaller_id() {
		return this.caller_id;
	}

	public void setCaller_id(int caller_id) {
		this.caller_id = caller_id;
	}

	public int getIsCalled() {
		return this.isCalled;
	}

	public void setIsCalled(int isCalled) {
		this.isCalled = isCalled;
	}

	public int getIsSuccess() {
		return this.isSuccess;
	}

	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getCaller_name() {
		return this.caller_name;
	}

	public void setCaller_name(String caller_name) {
		this.caller_name = caller_name;
	}

}
