package com.taketicket.manager.services;

import java.util.List;

import com.taketicket.entity.Caller;

public interface CallerService {

	public abstract int insertCaller(Caller caller);

	public abstract int deleteCallerByAccount(String account);

	public abstract int deleteCallerByName(String name);

	public abstract int updatePasswordByAccount(Caller caller);

	public abstract Caller queryByAccount(String account);

	public abstract List<Caller> queryByName(String name);

	public abstract List<Caller> queryAll();

	public abstract int updateDisableByAccount(Caller caller);
}
