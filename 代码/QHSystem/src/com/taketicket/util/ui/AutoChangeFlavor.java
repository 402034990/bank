package com.taketicket.util.ui;

import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.taketicket.constant.Flavor;
import com.taketicket.manager.ui.UserManage;

public class AutoChangeFlavor implements Runnable {

	private Thread thread = null;

	private JLabel picLabel = null;

	public AutoChangeFlavor(JLabel picLabel) {
		this.picLabel = picLabel;
	}

	public void autoChangeFlavor() {

		if (this.thread == null) {
			this.thread = new Thread(this);
		}
		this.thread.start();
	}

	@Override
	public void run() {

		Calendar calendar = null;
		int month = -1;
		int day = -1;
		boolean isGuoqing = true;
		boolean isLaodong = true;
		boolean isErtong = true;
		boolean isYuandan = true;
		boolean isOther = true;

		while (true) {

			calendar = Calendar.getInstance();
			month = calendar.get(Calendar.MONTH) + 1;
			day = calendar.get(Calendar.DATE);
			try {
				if (day == 1) {

					if (isGuoqing && month == 10 && day == 1) {

						isGuoqing = false;
						isLaodong = true;
						isErtong = true;
						isYuandan = true;
						isOther = true;

						System.out.println("国庆节");
						this.picLabel
								.setIcon(new ImageIcon(
										UserManage.class
												.getResource("/resource/images/background/guoqing.jpg")));

					} else if (isLaodong && month == 5 && day == 1) {

						isLaodong = false;
						isGuoqing = true;
						isErtong = true;
						isYuandan = true;
						isOther = true;

						System.out.println("劳动节");
						this.picLabel
								.setIcon(new ImageIcon(
										UserManage.class
												.getResource("/resource/images/background/laodong.jpg")));

					} else if (isErtong && month == 6 && day == 1) {

						isErtong = false;
						isGuoqing = true;
						isLaodong = true;
						isYuandan = true;
						isOther = true;

						System.out.println("儿童节");
						this.picLabel
								.setIcon(new ImageIcon(
										UserManage.class
												.getResource("/resource/images/background/ertong.jpg")));

					} else if (isYuandan && month == 1 && day == 1) {

						isYuandan = false;
						isGuoqing = true;
						isLaodong = true;
						isErtong = true;
						isOther = true;

						System.out.println("元旦");
						this.picLabel
								.setIcon(new ImageIcon(
										UserManage.class
												.getResource("/resource/images/background/yuandan.jpg")));
					}

				} else if (isOther) {
					isOther = false;
					isYuandan = true;
					isGuoqing = true;
					isLaodong = true;
					isErtong = true;
					System.out.println("other");
					this.picLabel.setIcon(new ImageIcon(UserManage.class
							.getResource(Flavor.BACKGROUND_ICON_PATH)));
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			} catch (Exception e) {
				System.out.println("自动换肤异常");
				this.picLabel.setIcon(new ImageIcon(UserManage.class
						.getResource(Flavor.BACKGROUND_ICON_PATH)));
			}

		}
	}
}
