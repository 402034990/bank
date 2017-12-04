package com.taketicket.callnum.services.impl;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.taketicket.callnum.services.CallerLoginService;
import com.taketicket.constant.NetConstant;
import com.taketicket.dto.RequestMsg;
import com.taketicket.dto.ResponseMsg;
import com.taketicket.entity.Caller;
import com.taketicket.server.dao.CallerDAO;
import com.taketicket.server.dao.impl.CallerDAOImplJDBC;
import com.taketicket.util.net.NetUtil;

public class CallerLoginServiceImplJDBC implements CallerLoginService {

	private CallerDAO callerDAO = null;

	public CallerLoginServiceImplJDBC() {
		this.callerDAO = new CallerDAOImplJDBC();
	}

	@Override
	public Caller queryByAccount(String account) {
		if (account == null || account.trim().length() == 0) {// 如果输入为空格或者没有输入账号直接返回空值
			return null;
		} else {// 如果查询结果不为空接返回查询内容，否则返回空值
			// return this.callerDAO.queryByAccount(account);

			Caller result = null;
			try {

				RequestMsg<String> requestMsg = new RequestMsg<String>();
				requestMsg.setRequest(NetConstant.CALLER_LOGIN);
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
				if (responseMsg.getResponse() == NetConstant.RESULT_CALLER_LOGIN) {
					result = (Caller) responseMsg.getObj();

				}

			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			return result;
		}

	}

	// public boolean isLogin(User user) {
	// Boolean result = false;
	// try {
	//
	// RequestMsg<User> requestMsg = new RequestMsg<User>();
	// requestMsg.setRequest(Constans.USER_LOGIN);
	// requestMsg.setObj(user);
	//
	// // 发送这个DTO对象给Server
	// NetUtil.send(BaseServices.getDs(), requestMsg,
	// InetAddress.getByName("localhost"), Constans.SERVER_PORT);
	// // 考虑的接收服务器段的回应
	// DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
	// // 转化一个对象
	// ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
	// .conversObj(dp);
	// if (responseMsg.getResponse().equals(Constans.RESULT_USER_LOGIN)) {
	// result = (Boolean) responseMsg.getObj();
	//
	// }
	//
	// } catch (UnknownHostException e) {
	// e.printStackTrace();
	// }
	// return result;
	// }

}
