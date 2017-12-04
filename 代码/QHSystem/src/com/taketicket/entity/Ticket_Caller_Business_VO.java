package com.taketicket.entity;

import java.io.Serializable;
import java.util.Date;

public class Ticket_Caller_Business_VO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String caller_name;
	private int caller_id;
	private int window_num;
	private String business_name;
	private int isCalled;
	private int success;
	private Date ticket_takeDate;

	public Date getTicket_takeDate() {
		return this.ticket_takeDate;
	}

	public void setTicket_takeDate(Date ticket_takeDate) {
		this.ticket_takeDate = ticket_takeDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((this.business_name == null) ? 0 : this.business_name
						.hashCode());
		result = prime
				* result
				+ ((this.caller_name == null) ? 0 : this.caller_name.hashCode());
		result = prime * result + this.window_num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Ticket_Caller_Business_VO other = (Ticket_Caller_Business_VO) obj;
		if (this.business_name == null) {
			if (other.business_name != null) {
				return false;
			}
		} else if (!this.business_name.equals(other.business_name)) {
			return false;
		}
		if (this.caller_name == null) {
			if (other.caller_name != null) {
				return false;
			}
		} else if (!this.caller_name.equals(other.caller_name)) {
			return false;
		}
		if (this.window_num != other.window_num) {
			return false;
		}
		return true;
	}

	public int getSuccess() {
		return this.success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public int getIsCalled() {
		return this.isCalled;
	}

	public void setIsCalled(int isCalled) {
		this.isCalled = isCalled;
	}

	public String getCaller_name() {
		return this.caller_name;
	}

	public void setCaller_name(String caller_name) {
		this.caller_name = caller_name;
	}

	public int getCaller_id() {
		return this.caller_id;
	}

	public void setCaller_id(int caller_id) {
		this.caller_id = caller_id;
	}

	public int getWindow_num() {
		return this.window_num;
	}

	public void setWindow_num(int window_num) {
		this.window_num = window_num;
	}

	public String getBusiness_name() {
		return this.business_name;
	}

	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}

}
