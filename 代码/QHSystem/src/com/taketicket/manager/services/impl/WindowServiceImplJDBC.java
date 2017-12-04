package com.taketicket.manager.services.impl;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import com.taketicket.callnum.services.impl.BaseServices;
import com.taketicket.constant.NetConstant;
import com.taketicket.dto.RequestMsg;
import com.taketicket.dto.ResponseMsg;
import com.taketicket.entity.Business_WindowVO;
import com.taketicket.entity.Window;
import com.taketicket.manager.services.WindowService;
import com.taketicket.server.dao.WindowDAO;
import com.taketicket.server.dao.impl.WindowDAOImplJDBC;
import com.taketicket.util.net.NetUtil;

public class WindowServiceImplJDBC implements WindowService {
	WindowDAO windowDAO = null;

	public WindowServiceImplJDBC() {
		this.windowDAO = new WindowDAOImplJDBC();
		// TODO 自动生成的构造函数存根
	}

	@Override
	// 插入
	public int insertWindow(Window window) {
		if (window == null) {
			return 0;
		} else {
			// int row = this.windowDAO.insertWindow(window);
			// return row;
			int result = 0;
			try {

				RequestMsg<Window> requestMsg = new RequestMsg<Window>();
				requestMsg.setRequest(NetConstant.WINDOWDAO_INSERT_WINDOW);
				requestMsg.setObj(window);

				// 发送这个DTO对象给Server
				NetUtil.send(BaseServices.getDs(), requestMsg,
						InetAddress.getByName(NetConstant.SERVER_IP),
						NetConstant.SERVER_PORT);
				// 考虑的接收服务器段的回应
				DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
				// 转化一个对象
				ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
						.conversObj(dp);
				if (responseMsg.getResponse() == NetConstant.RESULT_WINDOWDAO_INSERT_WINDOW) {
					result = (Integer) responseMsg.getObj();

				}

			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			return result;

		}
	}

	@Override
	public int updateDisabledByNum(int num) {

		if (num < 0) {
			return 0;
		} else {
			// int row = this.windowDAO.updateDisabledByNum(num);
			// return row;
			int result = 0;
			try {

				RequestMsg<Integer> requestMsg = new RequestMsg<Integer>();
				requestMsg
						.setRequest(NetConstant.WINDOWDAO_UPDATE_DISABLED_BY_NUM);
				requestMsg.setObj(num);

				// 发送这个DTO对象给Server
				NetUtil.send(BaseServices.getDs(), requestMsg,
						InetAddress.getByName(NetConstant.SERVER_IP),
						NetConstant.SERVER_PORT);
				// 考虑的接收服务器段的回应
				DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
				// 转化一个对象
				ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
						.conversObj(dp);
				if (responseMsg.getResponse() == NetConstant.RESULT_WINDOWDAO_UPDATE_DISABLED_BY_NUM) {
					result = (Integer) responseMsg.getObj();

				}

			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			return result;
		}
	}

	@Override
	// 更新
	public int updateWindowByNum(Window window) {
		if (window == null) {
			return 0;
		} else {
			// int row = this.windowDAO.updateDisabledByNum(window);
			// return row;
			int result = 0;
			try {

				RequestMsg<Window> requestMsg = new RequestMsg<Window>();
				requestMsg
						.setRequest(NetConstant.WINDOWDAO_UPDATE_DISABLED_BY_NUM1);
				requestMsg.setObj(window);

				// 发送这个DTO对象给Server
				NetUtil.send(BaseServices.getDs(), requestMsg,
						InetAddress.getByName(NetConstant.SERVER_IP),
						NetConstant.SERVER_PORT);
				// 考虑的接收服务器段的回应
				DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
				// 转化一个对象
				ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
						.conversObj(dp);
				if (responseMsg.getResponse() == NetConstant.RESULT_WINDOWDAO_UPDATE_DISABLED_BY_NUM1) {
					result = (Integer) responseMsg.getObj();

				}

			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			return result;

		}
	}

	@Override
	public int updateWindowById(Window window) {
		if (window == null) {
			return 0;
		} else {
			// int row = this.windowDAO.updateWindowById(window);
			// return row;

			Integer result = null;
			try {

				RequestMsg<Window> requestMsg = new RequestMsg<Window>();
				requestMsg
						.setRequest(NetConstant.WINDOWDAO_UPDATE_WINDOW_BY_ID);
				requestMsg.setObj(window);

				// 发送这个DTO对象给Server
				NetUtil.send(BaseServices.getDs(), requestMsg,
						InetAddress.getByName(NetConstant.SERVER_IP),
						NetConstant.SERVER_PORT);
				// 考虑的接收服务器段的回应
				DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
				// 转化一个对象
				ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
						.conversObj(dp);
				if (responseMsg.getResponse() == NetConstant.RESULT_WINDOWDAO_UPDATE_WINDOW_BY_ID) {
					result = (Integer) responseMsg.getObj();

				}

			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			return result;
		}
	}

	@Override
	public int updateWindowByBusinessId(Window window) {
		if (window == null) {
			return 0;
		} else {
			// TODO 可能调用错方法
			// int row = this.windowDAO.updateWindowById(window);
			// return row;

			Integer result = null;
			try {

				RequestMsg<Window> requestMsg = new RequestMsg<Window>();
				requestMsg
						.setRequest(NetConstant.WINDOWDAO_UPDATE_WINDOW_BY_ID);
				requestMsg.setObj(window);

				// 发送这个DTO对象给Server
				NetUtil.send(BaseServices.getDs(), requestMsg,
						InetAddress.getByName(NetConstant.SERVER_IP),
						NetConstant.SERVER_PORT);
				// 考虑的接收服务器段的回应
				DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
				// 转化一个对象
				ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
						.conversObj(dp);
				if (responseMsg.getResponse() == NetConstant.RESULT_WINDOWDAO_UPDATE_WINDOW_BY_ID) {
					result = (Integer) responseMsg.getObj();

				}

			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			return result;

		}
	}

	@Override
	public int updateDisabledByBusinessId(int businessId) {

		if (businessId < 0) {
			return 0;
		} else {
			// int row = this.windowDAO.updateDisabledByBusinessId(businessId);
			// return row;

			Integer result = null;
			try {

				RequestMsg<Integer> requestMsg = new RequestMsg<Integer>();
				requestMsg
						.setRequest(NetConstant.WINDOWDAO_UPDATE_DISABLED_BY_BUSINESSID);
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
				if (responseMsg.getResponse() == NetConstant.RESULT_WINDOWDAO_UPDATE_DISABLED_BY_BUSINESSID) {
					result = (Integer) responseMsg.getObj();

				}

			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			return result;

		}
	}

	@Override
	public Window queryWindowById(int id) {

		if (id < 0) {
			return null;
		} else {

			// return this.windowDAO.queryWindowById(id);

			Window result = null;
			try {

				RequestMsg<Integer> requestMsg = new RequestMsg<Integer>();
				requestMsg.setRequest(NetConstant.WINDOWDAO_QUERY_WINDOW_BY_ID);
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
				if (responseMsg.getResponse() == NetConstant.RESULT_WINDOWDAO_QUERY_WINDOW_BY_ID) {
					result = (Window) responseMsg.getObj();

				}

			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			return result;
		}
	}

	@Override
	// 查询
	public Window queryWindowByNum(int num) {
		if (num < 0) {
			return null;
		} else {

			// return this.windowDAO.queryWindowByNum(num);

			Window result = null;
			try {

				RequestMsg<Integer> requestMsg = new RequestMsg<Integer>();
				requestMsg
						.setRequest(NetConstant.WINDOWDAO_QUERY_WINDOW_BY_NUM);
				requestMsg.setObj(num);

				// 发送这个DTO对象给Server
				NetUtil.send(BaseServices.getDs(), requestMsg,
						InetAddress.getByName(NetConstant.SERVER_IP),
						NetConstant.SERVER_PORT);
				// 考虑的接收服务器段的回应
				DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
				// 转化一个对象
				ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
						.conversObj(dp);
				if (responseMsg.getResponse() == NetConstant.RESULT_WINDOWDAO_QUERY_WINDOW_BY_NUM) {
					result = (Window) responseMsg.getObj();

				}

			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			return result;
		}
	}

	@Override
	public Window queryWindowByBusinessId(int businessId) {
		if (businessId < 0) {
			return null;
		} else {

			// return this.windowDAO.queryWindowByBusinessId(businessId);

			Window result = null;
			try {

				RequestMsg<Integer> requestMsg = new RequestMsg<Integer>();
				requestMsg
						.setRequest(NetConstant.WINDOWDAO_QUERY_WINDOW_BY_BUSINESSID);
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
				if (responseMsg.getResponse() == NetConstant.RESULT_WINDOWDAO_QUERY_WINDOW_BY_BUSINESSID) {
					result = (Window) responseMsg.getObj();

				}

			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			return result;

		}
	}

	@Override
	public List<Window> queryAll() {

		// return this.windowDAO.queryAll();

		List<Window> result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg.setRequest(NetConstant.WINDOWDAO_QUERY_ALL);
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
			if (responseMsg.getResponse() == NetConstant.RESULT_WINDOWDAO_QUERY_ALL) {
				result = (List<Window>) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Business_WindowVO> queryAllForBusinessVO() {

		// return this.windowDAO.queryAllForBusinessVO();

		List<Business_WindowVO> result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg
					.setRequest(NetConstant.WINDOWDAO_QUERY_ALL_FOR_BUSINESSVO);
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
			if (responseMsg.getResponse() == NetConstant.RESULT_WINDOWDAO_QUERY_ALL_FOR_BUSINESSVO) {
				result = (List<Business_WindowVO>) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Business_WindowVO> queryByNumForBusinessVO(int num) {

		// return this.windowDAO.queryByNumForBusinessVO(num);

		List<Business_WindowVO> result = null;
		try {

			RequestMsg<Integer> requestMsg = new RequestMsg<Integer>();
			requestMsg
					.setRequest(NetConstant.WINDOWDAO_QUERY_BY_NUM_FOR_BUSINESSVO);
			requestMsg.setObj(num);

			// 发送这个DTO对象给Server
			NetUtil.send(BaseServices.getDs(), requestMsg,
					InetAddress.getByName(NetConstant.SERVER_IP),
					NetConstant.SERVER_PORT);
			// 考虑的接收服务器段的回应
			DatagramPacket dp = NetUtil.recevice(BaseServices.getDs());
			// 转化一个对象
			ResponseMsg<?> responseMsg = (ResponseMsg<?>) NetUtil
					.conversObj(dp);
			if (responseMsg.getResponse() == NetConstant.RESULT_WINDOWDAO_QUERY_BY_NUM_FOR_BUSINESSVO) {
				result = (List<Business_WindowVO>) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Business_WindowVO> queryByBusinessNameForBusinessVO(String name) {

		// return this.windowDAO.queryByBusinessNameForBusinessVO(name);

		List<Business_WindowVO> result = null;
		try {

			RequestMsg<String> requestMsg = new RequestMsg<String>();
			requestMsg
					.setRequest(NetConstant.WINDOWDAO_QUERY_BY_BUSINESS_NAME_FOR_BUSINESSVO);
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
			if (responseMsg.getResponse() == NetConstant.RESULT_WINDOWDAO_QUERY_BY_BUSINESS_NAME_FOR_BUSINESSVO) {
				result = (List<Business_WindowVO>) responseMsg.getObj();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

}
