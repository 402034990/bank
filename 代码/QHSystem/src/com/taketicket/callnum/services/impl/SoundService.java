package com.taketicket.callnum.services.impl;

import com.taketicket.util.SoundUtil;

public class SoundService {
	public void play(String ticketNO, String windowNo)
			throws InterruptedException {
		// 调用声音“请”
		SoundUtil.invokSound("bin/resource/sound/plese.wav");
		Thread.sleep(500);
		// 调用声音"XXX"号
		for (int i = 0; i < ticketNO.length(); i++) {
			SoundUtil.invokSound("bin/resource/sound/" + ticketNO.charAt(i)
					+ ".wav");
			Thread.sleep(500);
		}
		// 调用声音"号"
		SoundUtil.invokSound("bin/resource/sound/num.wav");
		Thread.sleep(500);
		// 调用声音“到”
		SoundUtil.invokSound("bin/resource/sound/to.wav");
		Thread.sleep(500);
		for (int i = 0; i < windowNo.length(); i++) {
			SoundUtil.invokSound("bin/resource/sound/" + windowNo.charAt(i)
					+ ".wav");
			Thread.sleep(500);
		}
		SoundUtil.invokSound("bin/resource/sound/handle.wav");
		Thread.sleep(3000);
	}
}
