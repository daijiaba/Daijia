
import java.io.BufferedReader; 

import java.io.IOException; 

import java.io.InputStreamReader; 

import java.io.PrintStream; 

import java.net.Socket;  

import java.net.UnknownHostException;  


public class SendMessage extends Thread{  

String str=null; 

public SendMessage(String str){  

this.str=str; 

} 

public void run(){  

Socket s = null;  

while(true){ 

try { 

s = new Socket("127.0.0.1",4545); 

break; 

} catch (Exception e) { 
 
} 

} 

System.out.println("连接上对方了"); 

try { 

PrintStream p = new PrintStream(s.getOutputStream()); 

p.println(str); 

p.flush();  

} catch (Exception e)
{ System.out.println("对方下线了"); 

} 

} 

}
