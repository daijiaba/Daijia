package cn.daijia.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HandlerThread extends Thread{

	private Socket client;

	public HandlerThread(Socket c) {
		this.client = c;
	}

	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream());
			
			String str = in.readLine();
			System.out.println(str);
			out.println("has receive....");
			out.flush();

			client.close();
		} catch (IOException ex) {
		} finally {

		}
	}

}
