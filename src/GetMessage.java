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

System.out.println("�˿ڱ�ռ����"); 

}  

Socket s = null; 

try { 

s = so.accept(); 
 

} catch (IOException e) { 


System.out.println("��ض˿ڵ�ʱ�������"); 

} 
 

if(s != null){ 

System.out.println("�пͻ��˷�����...."); 

while(true){ 

try { 

InputStreamReader i = new InputStreamReader(s.getInputStream()); 

BufferedReader b = new BufferedReader(i); 

String str2 = b.readLine(); 

System.out.println("�Է�˵" + str2); 

 } catch (IOException e) { System.out.println("�Է�������"); 
break; 
 
} 

} 

} 

} 

}

