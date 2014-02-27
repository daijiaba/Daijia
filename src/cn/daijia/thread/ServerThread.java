package cn.daijia.thread;

import java.net.*;
import java.io.*;

public class ServerThread extends Thread {
	
	public ServerThread(){
		
	}
	
	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(8888);
			System.out.println("41646546");
			while (true) {
				// transfer location change Single User or Multi User
				HandlerThread mu = new HandlerThread(server.accept());
				mu.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}