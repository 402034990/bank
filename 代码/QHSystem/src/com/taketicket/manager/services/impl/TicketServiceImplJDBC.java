package com.taketicket.manager.services.impl;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import com.taketicket.callnum.services.impl.BaseServices;
import com.taketicket.constant.NetConstant;
import com.taketicket.dto.RequestMsg;
import com.taketicket.dto.ResponseMsg;
import com.taketicket.entity.Ticket;
import com.taketicket.entity.TicketVO;
import com.taketicket.entity.Ticket_Caller_Business_VO;
import com.taketicket.entity.Ticket_TakeDate_VO;
import com.taketicket.manager.services.TicketService;
import com.taketicket.server.dao.TicketDAO;
import com.taketicket.server.dao.impl.TicketDAOImplJDBC;
import com.taketicket.util.net.NetUtil;

public class TicketServiceImplJDBC implements TicketService {
	private TicketDAO ticketDAO = null;

	public TicketServiceImplJDBC() {
		this.ticketDAO = new TicketDAOImplJDBC();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public int insertTicket(Ticket ticket) {
		if (ticket == null) {
			return 0;
		}
		// int row = this.ticketDAO.insertTicket(ticket);
		// return row;

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

	@Override
	public int updateById(Ticket ticket) {
		if (ticket == null) {
			return 0;
		}
		// int row = this.ticketDAO.updateById(ticket);
		// return row;

		Integer result = null;
		try {

			RequestMsg<Ticket> requestMsg = new RequestMsg<Ticket>();
			requestMsg.setRequest(NetConstant.TICKETDAO_UPDATE_BY_ID);
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
			if (responseMsg.getResponse() == NetConstant.RESULT_TICKETDAO_UPDATE_BY_ID) {
				result = (Integer) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Ticket queryByDate(Date date) {
		if (date == null) {
			return null;
		}
		// Ticket ticket = this.ticketDAO.queryByDate(date);
		// return ticket;

		Ticket result = null;
		try {

			RequestMsg<Date> requestMsg = new RequestMsg<Date>();
			requestMsg.setRequest(NetConstant.TICKETDAO_QUERY_BY_DATE);
			requestMsg.setObj(date);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_TICKETDAO_QUERY_BY_DATE) {
				result = (Ticket) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Ticket queryById(int id) {
		if (id < 0) {
			return null;
		}
		// Ticket ticket = this.ticketDAO.queryById(id);
		// return ticket;

		Ticket result = null;
		try {

			RequestMsg<Integer> requestMsg = new RequestMsg<Integer>();
			requestMsg.setRequest(NetConstant.TICKETDAO_QUERY_BY_ID);
			requestMsg.setObj(id);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_TICKETDAO_QUERY_BY_ID) {
				result = (Ticket) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Ticket queryByBusinessId(int businessId) {
		if (businessId < 0) {
			return null;
		}
		// Ticket ticket = this.ticketDAO.queryByBusinessId(businessId);
		// return ticket;

		Ticket result = null;
		try {

			RequestMsg<Integer> requestMsg = new RequestMsg<Integer>();
			requestMsg.setRequest(NetConstant.TICKETDAO_QUERY_BY_BUSINESS_ID);
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
			if (responseMsg.getResponse() == NetConstant.RESULT_TICKETDAO_QUERY_BY_BUSINESS_ID) {
				result = (Ticket) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Ticket> queryAll() {
		// List<Ticket> tickets = this.ticketDAO.queryAll();
		// return tickets;

		List<Ticket> result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg.setRequest(NetConstant.TICKETDAO_QUERY_ALL);
			requestMsg.setObj("");

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_TICKETDAO_QUERY_ALL) {
				result = (List<Ticket>) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Ticket> queryTicketsByBusinessId(int id) {
		// TODO Auto-generated method stub
		// return this.ticketDAO.queryTicketsByBusinessId(id);

		List<Ticket> result = null;
		try {

			RequestMsg<Integer> requestMsg = new RequestMsg<Integer>();
			requestMsg
					.setRequest(NetConstant.TICKETDAO_QUERY_TICKETS_BY_BUSINESS_ID);
			requestMsg.setObj(id);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_TICKETDAO_QUERY_TICKETS_BY_BUSINESS_ID) {
				result = (List<Ticket>) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<TicketVO> queryLogByTicketVO() {

		// return this.ticketDAO.queryLogByTicketVO();

		List<TicketVO> result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg.setRequest(NetConstant.TICKETDAO_QUERY_LOG_BY_TICKETVO);
			requestMsg.setObj("");

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_TICKETDAO_QUERY_LOG_BY_TICKETVO) {
				result = (List<TicketVO>) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Ticket_Caller_Business_VO> queryDataByTicket_Caller_Business_VO() {

		// return this.ticketDAO.queryDataByTicket_Caller_Business_VO();

		List<Ticket_Caller_Business_VO> result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg
					.setRequest(NetConstant.TICKETDAO_QUERY_DATA_BY_TICKET_CALLER_BUSINESS_VO);
			requestMsg.setObj("");

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_TICKETDAO_QUERY_DATA_BY_TICKET_CALLER_BUSINESS_VO) {
				result = (List<Ticket_Caller_Business_VO>) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Ticket_TakeDate_VO> queryDataByTicket_Caller_Business_VO1() {

		// return this.ticketDAO.queryDataByTicket_Caller_Business_VO1();

		List<Ticket_TakeDate_VO> result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg
					.setRequest(NetConstant.TICKETDAO_QUERY_DATA_BY_TICKET_CALLER_BUSINESS_VO1);
			requestMsg.setObj("");

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_TICKETDAO_QUERY_DATA_BY_TICKET_CALLER_BUSINESS_VO1) {
				result = (List<Ticket_TakeDate_VO>) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Ticket_Caller_Business_VO> queryDataByTicket_Caller_Business_VO2() {

		// return this.ticketDAO.queryDataByTicket_Caller_Business_VO2();

		List<Ticket_Caller_Business_VO> result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg
					.setRequest(NetConstant.TICKETDAO_QUERY_DATA_BY_TICKET_CALLER_BUSINESS_VO2);
			requestMsg.setObj("");

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_TICKETDAO_QUERY_DATA_BY_TICKET_CALLER_BUSINESS_VO2) {
				result = (List<Ticket_Caller_Business_VO>) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<TicketVO> queryDataByTicketVO() {

		// return this.ticketDAO.queryDataByTicketVO();

		List<TicketVO> result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg.setRequest(NetConstant.TICKETDAO_QUERY_DATA_BY_TICKETVO);
			requestMsg.setObj("");

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_TICKETDAO_QUERY_DATA_BY_TICKETVO) {
				result = (List<TicketVO>) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<TicketVO> queryCheckByTicketVO(int key) {

		// return this.ticketDAO.queryCheckByTicketVO();

		List<TicketVO> result = null;
		try {

			RequestMsg<Integer> requestMsg = new RequestMsg<Integer>();
			requestMsg
					.setRequest(NetConstant.TICKETDAO_QUERY_CHECK_BY_TICKETVO);
			requestMsg.setObj(key);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_TICKETDAO_QUERY_CHECK_BY_TICKETVO) {
				result = (List<TicketVO>) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Ticket queryByWaitCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TicketVO> querySuccessByTicketVO(int success) {

		// return this.ticketDAO.querySuccessByTicketVO(success);

		List<TicketVO> result = null;
		try {

			RequestMsg<Integer> requestMsg = new RequestMsg<Integer>();
			requestMsg
					.setRequest(NetConstant.TICKETDAO_QUERY_SUCCESS_BY_TICKETVO);
			requestMsg.setObj(success);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_TICKETDAO_QUERY_SUCCESS_BY_TICKETVO) {
				result = (List<TicketVO>) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

}
