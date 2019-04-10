package com.rjm.network.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerInfo {

	// sendClient 보냄
	public boolean sendClient(Socket sc, OutputStream os, OutputStreamWriter ow, BufferedWriter bw, Scanner ssc)
			throws Exception {
		os = sc.getOutputStream();
		ow = new OutputStreamWriter(os);
		bw = new BufferedWriter(ow);
		System.out.println("클라이언트로 보낼 메세지 입력");
		String s = ssc.next();
		bw.write(s);
		bw.write("\r\n");
		bw.flush();
		boolean check = true;
		if (s.equals("q")) {
			check = !check;
		}
		return check;
	}

	// receiveClient 받음
	public boolean receiveClient(Socket sc, InputStream is, InputStreamReader ir, BufferedReader br) throws Exception {
		is = sc.getInputStream();// byte
		ir = new InputStreamReader(is);// char
		br = new BufferedReader(ir);
		String s = br.readLine();
		boolean check = true;
		if (s.equals("q")) {
			check = !check;
		} else {
			System.out.println("Message : " + s);
		}
		return check;
	}

}
