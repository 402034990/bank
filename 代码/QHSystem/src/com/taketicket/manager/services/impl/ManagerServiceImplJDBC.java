package com.taketicket.manager.services.impl;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import com.taketicket.callnum.services.impl.BaseServices;
import com.taketicket.constant.NetConstant;
import com.taketicket.dto.RequestMsg;
import com.taketicket.dto.ResponseMsg;
import com.taketicket.entity.Manager;
import com.taketicket.manager.services.ManagerService;
import com.taketicket.server.dao.ManagerDAO;
import com.taketicket.server.dao.impl.ManagerDAOImplJDBC;
import com.taketicket.util.net.NetUtil;

public class ManagerServiceImplJDBC implements ManagerService {
	private ManagerDAO managerDAO = null;

	public ManagerServiceImplJDBC() {
		// TODO 自动生成的构造函数存根
		this.managerDAO = new ManagerDAOImplJDBC();
	}

	@Override
	public int insertManager(Manager manager) {
		if (manager == null) {
			return 0;
		}
		// int row = this.managerDAO.insertManager(manager);
		// return row;

		Integer result = 0;
		try {

			RequestMsg<Manager> requestMsg = new RequestMsg<Manager>();
			requestMsg.setRequest(NetConstant.MANAGERDAO_INSERT_MANAGER);
			requestMsg.setObj(manager);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_MANAGERDAO_INSERT_MANAGER) {
				result = (Integer) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteManagerByAccount(String account) {
		if (account == null || account.trim().length() == 0) {
			return 0;
		}
		// int row = this.managerDAO.deleteManagerByAccount(account);
		// return row;

		Integer result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg
					.setRequest(NetConstant.MANAGERDAO_DELETE_MANAGER_BY_ACCOUNT);
			requestMsg.setObj(account);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_MANAGERDAO_DELETE_MANAGER_BY_ACCOUNT) {
				result = (Integer) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public int deleteManagerByName(String name) {
		if (name == null || name.trim().length() == 0) {
			return 0;
		}
		// int row = this.managerDAO.deleteManagerByName(name);
		//
		// return row;

		Integer result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg
					.setRequest(NetConstant.MANAGERDAO_DELETE_MANAGER_BY_NAME);
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
			if (responseMsg.getResponse() == NetConstant.RESULT_MANAGERDAO_DELETE_MANAGER_BY_NAME) {
				result = (Integer) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updatePasswordByAccount(Manager manager) {
		if (manager == null) {
			return 0;
		}
		// int row = this.managerDAO.updatePasswordByAccount(manager);
		// return row;

		Integer result = null;
		try {

			RequestMsg<Manager> requestMsg = new RequestMsg<Manager>();
			requestMsg
					.setRequest(NetConstant.MANAGERDAO_UPDATE_PASSWORD_BY_ACCOUNT);
			requestMsg.setObj(manager);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_MANAGERDAO_UPDATE_PASSWORD_BY_ACCOUNT) {
				result = (Integer) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Manager queryByAccount(String account) {
		if (account == null || account.trim().length() == 0) {
			return null;
		}
		// Manager mana = this.managerDAO.queryByAccount(account);
		// return mana;

		Manager result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg.setRequest(NetConstant.MANAGERDAO_QUERY_BY_ACCOUNT);
			requestMsg.setObj(account);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_MANAGERDAO_QUERY_BY_ACCOUNT) {
				result = (Manager) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Manager queryByName(String name) {
		if (name == null || name.trim().length() == 0) {
			return null;
		}
		// Manager mana = this.managerDAO.queryByName(name);
		// return mana;

		Manager result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg.setRequest(NetConstant.MANAGERDAO_QUERY_BY_NAME);
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
			if (responseMsg.getResponse() == NetConstant.RESULT_MANAGERDAO_QUERY_BY_NAME) {
				result = (Manager) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Manager> queryAll() {

		// List<Manager> list = this.managerDAO.queryAll();
		// return list;

		List<Manager> result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg.setRequest(NetConstant.MANAGERDAO_QUERY_ALL);
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
			if (responseMsg.getResponse() == NetConstant.RESULT_MANAGERDAO_QUERY_ALL) {
				result = (List<Manager>) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateDisabledByAccount(Manager manager) {
		// TODO 自动生成的方法存根
		if (manager == null) {
			return 0;
		}
		// int row = this.managerDAO.updateDisabledByaccount(manager);
		// return row;

		Integer result = null;
		try {

			RequestMsg<Manager> requestMsg = new RequestMsg<Manager>();
			requestMsg
					.setRequest(NetConstant.MANAGERDAO_UPDATE_DISABLED_BY_ACCOUNT);
			requestMsg.setObj(manager);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_MANAGERDAO_UPDATE_DISABLED_BY_ACCOUNT) {
				result = (Integer) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;

	}

	// public int updateDisableByAccount(Manager manager) {
	// // TODO 自动生成的方法存根
	// if (manager == null) {
	// return 0;
	// }
	// int row = managerServiceImplJDBC.updateDisabledByaccount(manager);
	// return row;
	//
	// }

}
