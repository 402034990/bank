package com.taketicket.util.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Calendar;

import javax.swing.JPanel;

public class DrawClockPanel extends JPanel implements Runnable {

	private int hour;
	private int minutes;
	private int second;
	private int year;
	private int month;
	private int day;
	private int clockX;
	private int clockY;

	private int origin = 150;
	private int r = this.origin - 10;

	private String[] Weekdays = new String[] { "星期日", "星期一", "星期二", "星期三",
			"星期四", "星期五", "星期六" };

	@Override
	public void run() {

		while (true) {
			this.repaint();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void paint(Graphics g1) {

		super.paint(g1);

		Graphics2D g = (Graphics2D) g1;
		g.setColor(Color.black);
		g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
				RenderingHints.VALUE_STROKE_PURE);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		for (int i = 0, j = 12; i < 60; i++) {

			this.clockX = (int) (this.r * Math.sin(Math.PI / 30 * i)) + this.r
					+ 10;
			this.clockY = (int) (this.r + 10 - this.r
					* Math.cos(Math.PI / 30 * i));

			if (i % 5 == 0) {
				// g.fillOval(this.clockX - 4, this.clockY - 4, 8, 8);
				g.setFont(new Font("Curier", Font.BOLD, 20));
				if (j >= 10) {
					g.drawString("" + j, this.clockX - 10, this.clockY + 7);
				} else {
					g.drawString("" + j, this.clockX - 5, this.clockY + 7);
				}
				if (j == 12) {
					j = 0;
				}
				j++;
			} else {
				g.fillOval(this.clockX - 2, this.clockY - 2, 4, 4);
			}
		}

		Calendar calCurrent = Calendar.getInstance();

		int weekday = calCurrent.get(Calendar.DAY_OF_WEEK);
		this.day = calCurrent.get(Calendar.DATE);

		this.month = calCurrent.get(Calendar.MONTH) + 1;
		this.year = calCurrent.get(Calendar.YEAR);
		this.hour = calCurrent.get(Calendar.HOUR_OF_DAY);
		this.minutes = calCurrent.get(Calendar.MINUTE);
		this.second = calCurrent.get(Calendar.SECOND);

		int hourX = (int) (Math.sin(Math.PI / 6.0
				* (this.hour % 12 + (float) this.minutes / 60)) * (this.r * (0.5)))
				+ this.origin;
		int hourY = this.origin
				- (int) (Math.cos(Math.PI / 6.0
						* (this.hour % 12 + (float) this.minutes / 60))
						* this.r * 0.5);

		int minutesX = (int) (Math.sin(Math.PI / 30.0 * this.minutes) * (this.r * (1 - 0.3)))
				+ this.origin;
		int minutesY = this.origin
				- (int) (Math.cos(Math.PI / 30.0 * this.minutes) * (this.r * (1 - 0.3)));

		int secondX = (int) (Math.sin(Math.PI / 30.0 * this.second) * this.r)
				+ this.origin;
		int secondY = this.origin
				- (int) (Math.cos(Math.PI / 30.0 * this.second) * this.r);

		g.setColor(Color.magenta);
		g.setFont(new Font("Curier", 20, 20));
		g.drawString("今天是  " + this.year + "年" + this.month + "月" + this.day
				+ "日    " + this.Weekdays[weekday - 1], 10, 2 * this.r + 50);
		g.drawString("现在时刻   " + this.hour + ":" + this.minutes + ":"
				+ this.second, 10, 2 * this.r + 70);

		g.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		g.setColor(Color.red);
		g.drawLine(this.origin, this.origin, hourX, hourY);

		g.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		g.setColor(Color.blue);
		g.drawLine(this.origin, this.origin, minutesX, minutesY);

		g.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		g.setColor(Color.green);
		g.drawLine(this.origin, this.origin, secondX, secondY);
	}
}
