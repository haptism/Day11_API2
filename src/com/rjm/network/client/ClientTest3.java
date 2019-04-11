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
			sk = new Socket("127.0.0.1", 8282);
			System.out.println("1.Lunch \t 2.Dinner \t 3.Random");
			int select = sc.nextInt();
			os = sk.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			bw.write(select + "\r\n");
			bw.flush();

			is = sk.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			String result = br.readLine();
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		System.out.println("end");

	}

}