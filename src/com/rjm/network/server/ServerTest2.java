package com.rjm.network.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServerTest2 {

	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket sk = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		String names = null;

		try {
			ss = new ServerSocket(8282);
			sk = ss.accept();
			is = sk.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			names = br.readLine();
			
			// 작업
			String[] ar = names.split(",");
			Random r = new Random();
			int index = r.nextInt(ar.length);
			names = ar[index];

			os = sk.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			bw.write(names);
			bw.write("\r\n");
			bw.flush();

		} catch (Exception e) {
			// TODO: handle exception
			
		} finally {
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
				sk.close();
				ss.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}