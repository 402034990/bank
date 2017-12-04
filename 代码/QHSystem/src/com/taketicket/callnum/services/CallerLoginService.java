package com.taketicket.callnum.services;

import com.taketicket.entity.Caller;

public interface CallerLoginService {

	public abstract Caller queryByAccount(String account);

}
