package com.taketicket.entity;

import java.io.Serializable;

public class Business_WindowVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int windowId;
	private int windowNum;
	private String businessName;
	private int windowDisabled;
	private int isCalled;
	private int businessId;

	public int getBusinessId() {
		return this.businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public int getIsCalled() {
		return this.isCalled;
	}

	public void setIsCalled(int isCalled) {
		this.isCalled = isCalled;
	}

	public int getWindowId() {
		return this.windowId;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}

	public int getWindowNum() {
		return this.windowNum;
	}

	public void setWindowNum(int windowNum) {
		this.windowNum = windowNum;
	}

	public String getBusinessName() {
		return this.businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public int getWindowDisabled() {
		return this.windowDisabled;
	}

	public void setWindowDisabled(int windowDisabled) {
		this.windowDisabled = windowDisabled;
	}

}
