import java.io.BufferedInputStream; 

import java.io.BufferedReader; 

import java.io.FileReader; 

import java.io.IOException;  

import java.io.InputStreamReader; 

import java.net.ServerSocket; 

import java.net.Socket; 
 

  

import java.io.BufferedInputStream; 

import java.io.BufferedReader; 

import java.io.FileReader; 

import java.io.IOException;  

import java.io.InputStreamReader; 

import java.net.ServerSocket; 

import java.net.Socket; 

  

public class GetMessage extends Thread{ 

public void run(){  

ServerSocket so = null; 

try { 

so = new ServerSocket(4545); 

} catch (IOException e) { 

System.out.println("端口被占用了"); 

}  

Socket s = null; 

try { 

s = so.accept(); 
 

} catch (IOException e) { 


System.out.println("监控端口的时候出错了"); 

} 
 

if(s != null){ 

System.out.println("有客户端访问了...."); 

while(true){ 

try { 

InputStreamReader i = new InputStreamReader(s.getInputStream()); 

BufferedReader b = new BufferedReader(i); 

String str2 = b.readLine(); 

System.out.println("对方说" + str2); 

 } catch (IOException e) { System.out.println("对方下线了"); 
break; 
 
} 

} 

} 

} 

}

