package com.taketicket.callnum.services.impl;

import java.net.DatagramSocket;
import java.net.SocketException;

import com.taketicket.constant.NetConstant;

public class BaseServices {
	private static DatagramSocket ds;

	public static DatagramSocket getDs() {
		return BaseServices.ds;
	}

	static {
		BaseServices.ds = BaseServices.createSocket();
	}

	public static DatagramSocket createSocket() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(NetConstant.CLIENT_PORT);
			System.out.println("客户端已经启动，监听在：" + NetConstant.CLIENT_PORT
					+ "端口上。。。。。。");
		} catch (SocketException e) {
			System.out.println("当前端口：" + NetConstant.CLIENT_PORT
					+ "被占用了，正在尝试连接其他的端口...");
			NetConstant.CLIENT_PORT++;
			return BaseServices.createSocket();
		}
		return ds;
	}

}
