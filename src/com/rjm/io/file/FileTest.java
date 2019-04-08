package com.rjm.io.file;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {

		File file = new File("c:\\test\\ex1.txt");
		file = new File("C:\\test", "ex1.txt");
		file = new File("C:\\test");
		File file2 = new File(file, "ex1.txt");

		System.out.println(file.exists()); // 존재 합니까?
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(file.canExecute());
		System.out.println(file.getName()); // 파일이나 폴더의 이름을 넘김
		System.out.println(file.getParent());
		System.out.println(file.length()); // 파일의 크기

		File f = new File("C:\\");

		String[] ar = f.list(); // 이름
		File[] list = f.listFiles(); // 파일

		file = new File("C:\\test\\rjm\\test");

//		file.mkdir(); // 디렉토리 만들기
//		file.mkdirs(); // 디렉토리 만들기

		file = new File("C:\\test\\test2");
		file.delete();

		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
	}
}
