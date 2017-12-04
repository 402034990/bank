package com.taketicket.util.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.Timer;

public class MyClock implements ActionListener {

	private final JLabel clockLabel;

	private MyClock(JLabel clockLabel) {
		this.clockLabel = clockLabel;

	}

	public static void showTimeAtLabel(JLabel clockLabel) {
		MyClock mc = new MyClock(clockLabel);
		Timer t = new Timer(1000, mc);
		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		this.clockLabel.setText(MyClock.getDateTime());
		this.clockLabel.repaint();
	}

	public static String getDateTime() {
		Calendar c = Calendar.getInstance();
		String date = "" + c.get(Calendar.YEAR) + "年"
				+ (c.get(Calendar.MONTH) + 1) + "月" + c.get(Calendar.DATE)
				+ "日";

		String[] a = { "日", "一", "二", "三", "四", "五", "六" };
		String week = "星期" + a[c.get(Calendar.DAY_OF_WEEK) - 1];

		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		String time = df.format(c.getTime());

		String dateTime = date + week + time;
		return dateTime;
	}
}
