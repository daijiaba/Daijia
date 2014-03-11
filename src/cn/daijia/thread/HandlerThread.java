package cn.daijia.thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HandlerThread extends Thread{

	private Socket client;
	private File f = new File("c:\\is.txt");

	public HandlerThread(Socket c) {
		this.client = c;
	}
	
	public boolean isTrue(File f){
		return f.exists();
	}

	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream());
			
			String str = in.readLine();
			System.out.println(str);
			while (true) {
			while(!isTrue(f)){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("3514564654---------------");
			out.println("has receive....");
			out.flush();
			f.delete();
			}

		} catch (IOException ex) {
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
