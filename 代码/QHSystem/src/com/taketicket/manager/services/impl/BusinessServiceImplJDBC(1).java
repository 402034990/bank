package com.taketicket.manager.services.impl;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import com.taketicket.callnum.services.impl.BaseServices;
import com.taketicket.constant.NetConstant;
import com.taketicket.dto.RequestMsg;
import com.taketicket.dto.ResponseMsg;
import com.taketicket.entity.Business;
import com.taketicket.manager.services.BusinessService;
import com.taketicket.server.dao.BusinessDAO;
import com.taketicket.server.dao.impl.BusinessDAOImplJDBC;
import com.taketicket.util.net.NetUtil;

public class BusinessServiceImplJDBC implements BusinessService {

	private BusinessDAO businessDAO = null;

	public BusinessServiceImplJDBC() {
		this.businessDAO = new BusinessDAOImplJDBC();
	}

	@Override
	public int insertBusiness(Business business) {
		if (business == null) {
			return 0;
		}
		// int rows = this.businessDAO.insertBusiness(business);

		int result = 0;
		try {

			RequestMsg<Business> requestMsg = new RequestMsg<Business>();
			requestMsg.setRequest(NetConstant.BUSINESSDAO_INSERT_BUSINESS);
			requestMsg.setObj(business);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_BUSINESSDAO_INSERT_BUSINESS) {
				result = (Integer) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public int updateBusinessByCode(Business business) {
		if (business == null) {
			return 0;
		}
		// int row = this.businessDAO.updateDisabledByCode(business);

		int result = 0;
		try {

			RequestMsg<Business> requestMsg = new RequestMsg<Business>();
			requestMsg
					.setRequest(NetConstant.BUSINESSDAO_UPDATE_BUSINESS_BY_CODE);
			requestMsg.setObj(business);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_BUSINESSDAO_UPDATE_BUSINESS_BY_CODE) {
				result = (Integer) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;

		// return row;
	}

	@Override
	public int updateBusinessByName(Business business) {
		if (business == null) {
			return 0;
		}
		// int row = this.businessDAO.updateDisabledByName(business);

		int result = 0;
		try {

			RequestMsg<Business> requestMsg = new RequestMsg<Business>();
			requestMsg
					.setRequest(NetConstant.BUSINESSDAO_UPDATE_BUSINESS_BY_NAME);
			requestMsg.setObj(business);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_BUSINESSDAO_UPDATE_BUSINESS_BY_NAME) {
				result = (Integer) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public int updateBusinessById(Business business) {
		if (business == null) {
			return 0;
		}
		// int row = this.businessDAO.updateBusinessById(business);

		int result = 0;
		try {

			RequestMsg<Business> requestMsg = new RequestMsg<Business>();
			requestMsg
					.setRequest(NetConstant.UPDATE_BUSINESSDAO_BUSINESS_BY_ID);
			requestMsg.setObj(business);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_BUSINESSDAO_UPDATE_BUSINESS_BY_ID) {
				result = (Integer) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
		// return row;
	}

	@Override
	public Business queryByCode(String code) {
		if (code == null || code.trim().length() == 0) {
			return null;
		}
		// Business b = this.businessDAO.queryByCode(code);
		Business result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg.setRequest(NetConstant.BUSINESSDAO_QUERY_BY_CODE);
			requestMsg.setObj(code);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_BUSINESSDAO_QUERY_BY_CODE) {
				result = (Business) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;

		// return b;
	}

	@Override
	public Business queryByName(String name) {
		if (name == null || name.trim().length() == 0) {
			return null;
		}
		// Business b = this.businessDAO.queryByName(name);
		Business result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg.setRequest(NetConstant.BUSINESSDAO_QUERY_BY_NAME);
			requestMsg.setObj(name);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_BUSINESSDAO_QUERY_BY_NAME) {
				result = (Business) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public List<Business> queryAll() {

		// List<Business> list = this.businessDAO.queryAll();

		List<Business> result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg.setRequest(NetConstant.BUSINESSDAO_QUERY_ALL);
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
			if (responseMsg.getResponse() == NetConstant.RESULT_BUSINESSDAO_QUERY_ALL) {
				result = (List<Business>) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;

	}

	public int updateDisabledByCode(Business business) {

		if (business == null) {
			return 0;
		}
		Integer result = null;
		try {

			RequestMsg<Business> requestMsg = new RequestMsg<Business>();
			requestMsg
					.setRequest(NetConstant.BUSINESSDAO_UPDATE_DISABLED_BY_CODE);
			requestMsg.setObj(business);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_BUSINESSDAO_UPDATE_DISABLED_BY_CODE) {
				result = (Integer) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateDisabledByName(Business business) {

		if (business == null) {
			return 0;
		}
		Integer result = null;
		try {

			RequestMsg<Business> requestMsg = new RequestMsg<Business>();
			requestMsg
					.setRequest(NetConstant.BUSINESSDAO_UPDATE_DISABLED_BY_NAME);
			requestMsg.setObj(business);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_BUSINESSDAO_UPDATE_DISABLED_BY_NAME) {
				result = (Integer) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Business queryById(String id) {

		if (id == null || id.trim().length() == 0) {
			return null;
		}
		Business result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg.setRequest(NetConstant.BUSINESSDAO_QUERY_BY_ID);
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
			if (responseMsg.getResponse() == NetConstant.RESULT_BUSINESSDAO_QUERY_BY_ID) {
				result = (Business) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

}
