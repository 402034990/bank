package com.taketicket.callnum.services;

import java.util.List;

import com.taketicket.entity.Ticket;

public interface CallNumService {

	public abstract int insertTicket(Ticket ticket);

	public abstract int updateTicketById(Ticket ticket);

	public abstract Ticket queryByBusinessId(int businessId);

	public abstract List<Ticket> queryTicketAll();

	// public abstract Ticket queryByBusinessName(String name);
}
