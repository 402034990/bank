package com.taketicket.manager.services.impl;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.swing.JOptionPane;

import com.taketicket.callnum.services.impl.BaseServices;
import com.taketicket.constant.NetConstant;
import com.taketicket.dto.RequestMsg;
import com.taketicket.dto.ResponseMsg;
import com.taketicket.entity.Caller;
import com.taketicket.manager.services.CallerService;
import com.taketicket.server.dao.CallerDAO;
import com.taketicket.server.dao.impl.CallerDAOImplJDBC;
import com.taketicket.util.net.NetUtil;

public class CallerServiceImplJDBC implements CallerService {
	private CallerDAO callerDAO = null;

	public CallerServiceImplJDBC() {
		this.callerDAO = new CallerDAOImplJDBC();
	}

	@Override
	public int insertCaller(Caller caller) {
		if (caller == null) {
			return 0;
		}
		// int row = this.callerDAO.insertCaller(caller);

		int result = 0;
		try {

			RequestMsg<Caller> requestMsg = new RequestMsg<Caller>();
			requestMsg.setRequest(NetConstant.CALLERDAO_INSERTCALLER);
			requestMsg.setObj(caller);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_CALLERDAO_INSERTCALLER) {
				result = (Integer) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "网络传输存在问题，操作不成功");

		}
		return result;

	}

	@Override
	public int deleteCallerByAccount(String account) {
		if (account == null || account.trim().length() == 0) {
			return 0;
		}
		// int row = this.callerDAO.deleteCallerByAccount(account);
		int result = 0;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg.setRequest(NetConstant.CALLERDAO_DELETECALLERBYACCOUNT);
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
			if (responseMsg.getResponse() == NetConstant.RESULT_CALLERDAO_DELETECALLERBYACCOUNT) {
				result = (Integer) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public int deleteCallerByName(String name) {
		if (name == null || name.trim().length() == 0) {
			return 0;
		}
		// int row = this.callerDAO.deleteCallerByName(name);

		int result = 0;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg.setRequest(NetConstant.CALLERDAO_DELETE_CALLER_BY_NAME);
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
			if (responseMsg.getResponse() == NetConstant.RESULT_CALLERDAO_DELETE_CALLER_BY_NAME) {
				result = (Integer) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public int updatePasswordByAccount(Caller caller) {
		if (caller == null) {
			return 0;
		}
		// int row = this.callerDAO.updatePasswordByAccount(caller);

		int result = 0;
		try {

			RequestMsg<Caller> requestMsg = new RequestMsg<Caller>();
			requestMsg
					.setRequest(NetConstant.CALLERDAO_UPDATE_PASSWORD_BY_ACCOUNT);
			requestMsg.setObj(caller);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_CALLERDAO_UPDATE_PASSWORD_BY_ACCOUNT) {
				result = (Integer) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Caller queryByAccount(String account) {

		if (account == null || account.trim().length() == 0) {
			return null;
		}
		// Caller caller = this.callerDAO.queryByAccount(account);
		Caller result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg.setRequest(NetConstant.CALLERDAO_QUERY_BY_ACCOUNT);
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
			if (responseMsg.getResponse() == NetConstant.RESULT_CALLERDAO_QUERY_BY_ACCOUNT) {
				result = (Caller) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public List<Caller> queryByName(String name) {
		if (name == null || name.trim().length() == 0) {
			return null;
		}
		// List<Caller> list = this.callerDAO.queryByName(name);
		List<Caller> result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg.setRequest(NetConstant.CALLERDAO_QUERY_BY_NAME);
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
			if (responseMsg.getResponse() == NetConstant.RESULT_CALLERDAO_QUERY_BY_NAME) {
				result = (List<Caller>) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public List<Caller> queryAll() {
		// List<Caller> list = this.callerDAO.queryAll();
		List<Caller> result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg.setRequest(NetConstant.CALLERDAO_QUERY_ALL);
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
			if (responseMsg.getResponse() == NetConstant.RESULT_CALLERDAO_QUERY_ALL) {
				result = (List<Caller>) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public int updateDisableByAccount(Caller caller) {
		// TODO 自动生成的方法存根
		if (caller == null) {
			return 0;
		}
		// int row = this.callerDAO.updateDisabledByAccount(caller);

		int result = 0;
		try {

			RequestMsg<Caller> requestMsg = new RequestMsg<Caller>();
			requestMsg
					.setRequest(NetConstant.CALLERDAO_UPDATE_DISABLED_BY_ACCOUNT);
			requestMsg.setObj(caller);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_CALLERDAO_UPDATE_DISABLED_BY_ACCOUNT) {
				result = (Integer) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;

	}

}
