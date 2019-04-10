package com.rjm.network.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class ClientTest3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Socket sk = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;

		try {
			sk = new Socket("211.238.142.21", 8180);
			os = sk.getOutputStream();// byte
			ow = new OutputStreamWriter(os);// char
			bw = new BufferedWriter(ow);
			System.out.println("명단 입력");
			String names = sc.next();
			bw.write(names);
			bw.write("\r\n");
			bw.flush();

			is = sk.getInputStream();// byte
			ir = new InputStreamReader(is);// char
			br = new BufferedReader(ir);
			names = br.readLine();

			System.out.println("당첨자 : " + names);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		} finally {
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
				sk.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}