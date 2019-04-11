package com.rjm.network.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

public class ServerMenu {
	private String[] lunch;// 점심 메뉴들을 담을 변수
	private String[] dinner;// 저녁 메뉴들을 담을 변수

	// 사전작업
	public void init() throws Exception {
		File file = new File("c:\\test\\lunch.txt");
		// lunch
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		br.readLine();
		String menus = br.readLine();
		lunch = menus.split("-");
		br.close();
		fr.close();
		file = new File("c:\\test\\dinner.txt");
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		br.readLine();
		menus = br.readLine();
		dinner = menus.split("-");
		br.close();
		fr.close();

	}

	// getRandom
	public String getRandom() {
		String menu = null;
		Random random = new Random();
		int index = random.nextInt(lunch.length + dinner.length);
		if (index > 4) {
			index = index - lunch.length;
			menu = dinner[index];
		} else {
			menu = lunch[index];
		}

		return menu;
	}

	// getLunch
	public String getLunch() {
		String menu = null;
		Random r = new Random();
		int index = r.nextInt(lunch.length);
		menu = lunch[index];
		return menu;
	}

	// getDinner
	public String getDinner() {
		String menu = null;
		Random r = new Random();
		int index = r.nextInt(dinner.length);
		menu = dinner[index];
		return menu;
	}

}