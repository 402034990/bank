package com.taketicket.util.net;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class NetUtil {
	public static void send(DatagramSocket ds, Object obj, InetAddress ip,
			int port) {
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			byte[] bs = bos.toByteArray();
			DatagramPacket datagramPacket = new DatagramPacket(bs, bs.length,
					ip, port);
			ds.send(datagramPacket);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object conversObj(DatagramPacket dp) {
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		Object obj = null;
		try {
			bis = new ByteArrayInputStream(dp.getData());
			ois = new ObjectInputStream(bis);
			obj = ois.readObject();
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public static DatagramPacket recevice(DatagramSocket ds) {
		byte[] br = new byte[10000];
		DatagramPacket dp = null;
		dp = new DatagramPacket(br,br.length);
		try {
			ds.receive(dp);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return dp;
	}
}
