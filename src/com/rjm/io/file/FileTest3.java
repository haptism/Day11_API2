package com.rjm.io.file;

import java.io.File;

public class FileTest3 {

	public static void main(String[] args) {

		File file = new File("C:\\test");

		String str = "iu-suji-choa,hani";

		str = str.replace(",", "-");
		
		String[] names = str.split("-");

		for (int i = 0; i < names.length; i++) {

			File file2 = new File(file, names[i]);
			boolean check = file2.mkdir();
			if (check) {
				System.out.println("Create Directory");
			} else {
				System.out.println("Create Fail");
			}
		}
	}
}
