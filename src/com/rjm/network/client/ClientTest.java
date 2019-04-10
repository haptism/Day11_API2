package com.rjm.network.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientTest {

	public static void main(String[] args) {
		Socket s = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		Scanner sc = new Scanner(System.in);

		try {
			s = new Socket("211.238.142.29", 8180);
			System.out.println("서버와 접속 성공");
			while (true) {
				os = s.getOutputStream();// byte
				ow = new OutputStreamWriter(os);// char
				bw = new BufferedWriter(ow);
				System.out.println("서버로 보낼 메세지 입력");
				String str = sc.next();// q
				bw.write(str);
				bw.write("\r\n");
				bw.flush();
				if (str.equals("q")) {
					break;
				}

				is = s.getInputStream();// byte
				ir = new InputStreamReader(is);// char
				br = new BufferedReader(ir);
				str = br.readLine();
				if (str.equals("q")) {
					break;
				}
				System.out.println("Message : " + str);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				ow.close();
				os.close();
				br.close();
				ir.close();
				is.close();
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Client 종료");

	}

}