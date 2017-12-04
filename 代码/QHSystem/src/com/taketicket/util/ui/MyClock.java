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
		String date = "" + c.get(Calendar.YEAR) + "��"
				+ (c.get(Calendar.MONTH) + 1) + "��" + c.get(Calendar.DATE)
				+ "��";

		String[] a = { "��", "һ", "��", "��", "��", "��", "��" };
		String week = "����" + a[c.get(Calendar.DAY_OF_WEEK) - 1];

		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		String time = df.format(c.getTime());

		String dateTime = date + week + time;
		return dateTime;
	}
}
