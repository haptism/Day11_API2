package com.rjm.network.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest3 {

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
		ServerMenu sm = new ServerMenu();

		try {
			sm.init();
			ss = new ServerSocket(8282);
			sk = ss.accept();
			is = sk.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			String check = br.readLine();
			if (check.equals("1")) {
				check = sm.getLunch();
			} else if (check.equals("2")) {
				check = sm.getDinner();
			} else {
				check = sm.getRandom();
			}

			os = sk.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			bw.write(check + "\r\n");
			bw.flush();

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
				ss.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}