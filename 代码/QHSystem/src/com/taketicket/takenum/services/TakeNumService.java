package com.taketicket.takenum.services;

import com.taketicket.entity.Ticket;

public interface TakeNumService {

	public abstract int insertTicket(Ticket ticket);

	public abstract Ticket queryByBusinessId(int businessId);
}
