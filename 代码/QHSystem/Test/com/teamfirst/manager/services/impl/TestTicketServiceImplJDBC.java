package com.teamfirst.manager.services.impl;

import java.util.Date;
import java.util.List;

import com.taketicket.entity.Ticket;
import com.taketicket.manager.services.impl.TicketServiceImplJDBC;

public class TestTicketServiceImplJDBC {

	private static TicketServiceImplJDBC ticketServiceImplJDBC = new TicketServiceImplJDBC();

	private static Ticket ticket = new Ticket(3, 1, 1, 1, new Date(), 125,
			"192.168.1.2222", 1, 2, "tom");

	public static void main(String[] args) {

		TestTicketServiceImplJDBC.queryAll();
	}

	public static void queryAll() {

		List<Ticket> tickets = TestTicketServiceImplJDBC.ticketServiceImplJDBC
				.queryAll();
		System.out.println(tickets.size());
		System.out.println(tickets.get(5).getIsSuccess());
		// System.out.println(ticket.getTakeDate());
	}

	public static void queryByBusinessId() {

		Ticket ticket = TestTicketServiceImplJDBC.ticketServiceImplJDBC
				.queryByBusinessId(1);
		System.out.println(ticket.getId());
		System.out.println(ticket.getTakeDate());
	}

	public static void queryById() {

		Ticket ticket = TestTicketServiceImplJDBC.ticketServiceImplJDBC
				.queryById(3);
		System.out.println(ticket.getBusiness_id());
		System.out.println(ticket.getTakeDate());
	}

	public static void queryByDateTest() {

		Date date = new Date();
		Ticket ticket = TestTicketServiceImplJDBC.ticketServiceImplJDBC
				.queryByDate(date);
		System.out.println(ticket);
	}

	public static void updateByIdTest() {

		int rows = TestTicketServiceImplJDBC.ticketServiceImplJDBC
				.updateById(TestTicketServiceImplJDBC.ticket);

		if (rows == 1) {
			System.out.println("���³ɹ�");
		} else if (rows == 0) {
			System.out.println("����ʧ��");
		} else {
			System.out.println("�Ƿ�!!");
		}
	}

	public static void insertTicketTest() {

		int rows = TestTicketServiceImplJDBC.ticketServiceImplJDBC
				.insertTicket(TestTicketServiceImplJDBC.ticket);

		if (rows == 1) {
			System.out.println("����ɹ�");
		} else if (rows == 0) {
			System.out.println("����ʧ��");
		} else {
			System.out.println("�Ƿ�!!");
		}
	}
}
