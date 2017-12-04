package com.taketicket.takenum.services.impl;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.taketicket.callnum.services.impl.BaseServices;
import com.taketicket.constant.NetConstant;
import com.taketicket.dto.RequestMsg;
import com.taketicket.dto.ResponseMsg;
import com.taketicket.entity.Ticket;
import com.taketicket.server.dao.TicketDAO;
import com.taketicket.server.dao.impl.TicketDAOImplJDBC;
import com.taketicket.takenum.services.TakeNumService;
import com.taketicket.util.net.NetUtil;

public class TakeNumSeviceImplJDBC implements TakeNumService {

	private TicketDAO ticketDAO = null;

	public TakeNumSeviceImplJDBC() {
		this.ticketDAO = new TicketDAOImplJDBC();
	}

	@Override
	public int insertTicket(Ticket ticket) {
		if (ticket == null) {
			return 0;
		} else {
			/*
			 * int rows = ticketDAO.insertTicket(ticket);
			 * 
			 * return rows;
			 */

			Integer result = null;
			try {

				RequestMsg<Ticket> requestMsg = new RequestMsg<Ticket>();
				requestMsg.setRequest(NetConstant.TICKETDAO_INSERT_TICKET);
				requestMsg.setObj(ticket);

				// 发送这个DTO对象给Server
				NetUtil.send(BaseServices.getDs(), requestMsg,
						InetAddress.getByName(NetConstant.SERVER_IP),
						NetConstant.SERVER_PORT);
				// 考虑的接收服务器段的回应
				DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
				// 转化一个对象
				ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
						.conversObj(dp);
				if (responseMsg.getResponse() == NetConstant.RESULT_TICKETDAO_INSERT_TICKET) {
					result = (Integer) responseMsg.getObj();

				}

			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			return result;
		}
	}

	@Override
	public Ticket queryByBusinessId(int businessId) {

		// return ticketDAO.queryByBusinessId(businessId);

		Ticket result = null;
		try {

			RequestMsg<Integer> requestMsg = new RequestMsg<Integer>();
			requestMsg.setRequest(NetConstant.TICKETDAO_QUERY_BY_BUSINESSID1);
			requestMsg.setObj(businessId);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_TICKETDAO_QUERY_BY_BUSINESSID1) {
				result = (Ticket) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

}
