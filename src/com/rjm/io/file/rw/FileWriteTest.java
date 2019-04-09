package com.rjm.io.file.rw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest {

	public static void main(String[] args) {

		File file = new File("C:\\Test", "WriteTest.txt");
		FileWriter fw = null;

		try {
//			fw = new FileWriter(file, true); // exception이 발생하기 때문에
			fw = new FileWriter(file, false);
			fw.write("\r\nFourth write");
			fw.flush(); // 버퍼를 강제로 비우기

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				fw.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("파일 작성 완료");
	}
}
