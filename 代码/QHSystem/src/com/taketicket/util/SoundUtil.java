package com.taketicket.util;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;


public class SoundUtil {
	public static void invokSound(String Filename) {
		URL url;
		try {
			url = new URL("file:" + Filename);
			AudioClip ac = Applet.newAudioClip(url);
			ac.play();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}