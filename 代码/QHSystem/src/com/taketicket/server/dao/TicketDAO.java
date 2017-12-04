package com.taketicket.server.dao;

import java.util.Date;
import java.util.List;

import com.taketicket.entity.Ticket;
import com.taketicket.entity.TicketVO;
import com.taketicket.entity.Ticket_Caller_Business_VO;
import com.taketicket.entity.Ticket_TakeDate_VO;

public interface TicketDAO {

	public abstract int insertTicket(Ticket ticket);

	public abstract int updateById(Ticket ticket);

	public abstract Ticket queryByDate(Date date);

	public abstract Ticket queryById(int id);

	public abstract Ticket queryByBusinessId(int businessId);

	public abstract List<Ticket> queryAll();

	public abstract List<Ticket> queryTicketsByBusinessId(int id);

	public abstract List<Ticket> queryAllByisCalled(int isCalled);

	// public abstract Object updattByisCalle();

	public abstract void updateByid(int id);

	public abstract List<TicketVO> queryLogByTicketVO();

	public abstract List<Ticket_Caller_Business_VO> queryDataByTicket_Caller_Business_VO();

	public abstract List<Ticket_TakeDate_VO> queryDataByTicket_Caller_Business_VO1();

	public abstract List<TicketVO> queryDataByTicketVO();

	public abstract List<TicketVO> queryCheckByTicketVO(int key);

	public abstract int updateByID(Ticket ticket);

	public abstract List<Ticket_Caller_Business_VO> queryDataByTicket_Caller_Business_VO2();

	public abstract List<TicketVO> querySuccessByTicketVO(int success);

}
