package com.rjm.io.file;

import java.io.File;

public class FileTest2 {

	public static void main(String[] args) {

		// list
		// 파일이라면 파일 크기를 출력
		// 디렉터리라면 폴더입니다. 출력

		// 프로젝트 현재 폴더를 객체로 생성한다.
		File file = new File("c:\\");

		// file이 존재하고 폴더일 경우
		if (file.exists() && file.isDirectory()) {

			// 폴더의 파일/폴더 목록을 문자열 배열로 반환
			String[] fList = file.list();

			// 출력
			for (int i = 0; i < fList.length; i++)
				System.out.println(fList[i]);

			System.out.println(file.getName() + "의 길이는 " + file.length() + " 입니다.");

		} else {
			System.out.println("해당 경로는 폴더가 아닙니다.");
		}
	}

	File[] lists = File.listRoots();
}
