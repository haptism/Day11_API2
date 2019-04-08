package com.rjm.io.file;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class FileEx1 {

	public void ex3() {

		// Calendar
		String filename = "";
		Calendar ca = Calendar.getInstance();

		long t = ca.getTimeInMillis();

		filename = "D" + t;
		File file = new File("C:\\test\\", filename);
		file.mkdir();

	}

	public void ex2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("폴더명 입력");
		String name = sc.next();
		File file = new File("C:\\test", name);

		if (file.exists()) {
			file.delete();
		} else {
			file.mkdir();
		}

	}

	public void ex1() {

		File file = new File("C:\\test\\iu");

		// 확장자, bmp, jpg, png

		// 파일들의 확장자를 가져올것

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("bmp", "img");
		map.put("jpg", "img");
		map.put("gif", "img");
		map.put("png", "img");
		map.put("jpeg", "img");

		String[] names = file.list();
		for (int i = 0; i < names.length; i++) {
			int index = names[i].lastIndexOf('.');
			String n = names[i].substring(index + 1);

			if (!(map.get(n) != null && map.get(n).equals("img"))) {
				File file2 = new File(file, names[i]);
				file2.delete();
			}
		}
	}
}
