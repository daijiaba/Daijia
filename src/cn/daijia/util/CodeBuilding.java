package cn.daijia.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.aop.ThrowsAdvice;

import cn.daijia.action.TestAction;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

public class CodeBuilding {
	
	private static final String MAIN = "[**]";
	private static final String METHOD = "[*1]";
	private static final String RTNTYPE = "[*2]";
	private static final String RTNNAME = "[*3]";
	private static final String PARA = "[*4]";
	private static final String PUREPARA = "[*44]";
	private static final String QUERY = "[*5]";
	private static final String separator = System.getProperty("line.separator");
	
	public static void main(String[] arg){//../action/TestAction.java
		String s;
		BufferedReader rt = null;
		RandomAccessFile r = null;
		Scanner scan = new Scanner(System.in);
//		CtClass ct;
//		Class cl = TestAction.class;
//		try {
//			ClassPool cp = ClassPool.getDefault() ;
//			System.out.println(cl.getName());
//			ct = cp.get("cn.daijia.action.TestAction");
//			CtMethod[] ctm = ct.getDeclaredMethods();
//			System.out.println(ctm[0].g);
//			CtClass type = cp.get("java.lang.Integer");
//			CtField f;
////			try {
////				f = new CtField(type, "ijk", ct);
////				ct.addField(f);
////			} catch (CannotCompileException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
//
//			System.out.println(ctm[0].getName());
//		} catch (NotFoundException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("Class main name:");
		String main = scan.next().trim();
		System.out.println("Method name:");
		String method = scan.next().trim();
		System.out.println("return data:  (Like 'int i'!)");
		String rtnType = scan.next().trim();
		String rtnName = scan.next().trim();
		System.out.println("PARA:  (Like 'int id, String name')");
		scan.nextLine();
		String para = scan.nextLine().trim();
//		String purepara = para.trim().replaceAll("[a-zA-Z]*\\s", "");
		
		/**
		 * purepara
		 */
		String[] paras = para.trim().split(",");
		String purepara = "";
		StringBuffer sbtmp = new StringBuffer();	
		if(!"".equals(para.trim())){
			String[] stmps;
			for(String stmp : paras){
				try{
					stmps = stmp.split("[\\s]+");
					stmp = "".equals(stmps[0].trim()) ? stmps[2].trim() : stmps[1].trim();
					sbtmp.append(stmp).append(",");
//					pureparaList.add(stmp.split("[\\s]+")[1].trim());
				}catch(NullPointerException e){		
					e.printStackTrace();
					System.err.println("参数错误！");
				}catch(ArrayIndexOutOfBoundsException e){
					e.printStackTrace();
					System.err.println("参数错误！");
				}
			}
			purepara = new String(sbtmp).substring(0,sbtmp.length()-1);
		}
		
		/**
		 * QUERY
		 */
		String query;
		int itmp = method.indexOf("By");
		if(itmp > 0){
			String vo = method.substring(3,itmp);
			String vid = method.substring(itmp+2).toLowerCase();
			byte[] btmps = vo.getBytes();
			byte[] vname = new byte[btmps.length];
			int i = 0;
			for(byte btmp : btmps){
				if(btmp >= 'A' && btmp <= 'Z') vname[i++] = btmp;
			}
			String stmp = new String(vname).trim().toLowerCase();
			query = vo + " " + stmp + " where " + stmp + "." + vid + "=?";
		}else{
			query = method.substring(3);
			byte[] btmps = query.getBytes();
			byte[] vname = new byte[btmps.length];
			int i = 0;
			for(byte btmp : btmps){
				if(btmp >= 'A' && btmp <= 'Z') vname[i++] = btmp;
			}
			query = query + " " + new String(vname).trim().toLowerCase();
		}
		
		
		
		try {
			File f1 = new File("");
			File tmp = new File(f1.getCanonicalPath() + "/WebRoot/template/template.dat");
			rt = new BufferedReader(new FileReader(tmp));
			s = rt.readLine().trim();
			while(s != null && s.equals("")){
				s = rt.readLine().trim();
			}
			boolean haveWrite = false;
			
			while(s != null){
				if(s.startsWith("@")){
					String ctype;
					if(s.startsWith("@Action")) ctype = "Action";
					else if(s.startsWith("@IService")) ctype = "IService";
					else if(s.startsWith("@Service")) ctype = "Service";
					else if(s.startsWith("@IDao")) ctype = "IDao";
					else if(s.startsWith("@Dao")) ctype = "Dao";
					else {
						System.out.println("@参数错误");
						break;
					}
					s = rt.readLine();
					r = getAccessFile(ctype, main);
					if(r == null) break;
					for(haveWrite = false;s != null && !s.startsWith("@");s = rt.readLine()){
						if(s.trim().equals("")) continue;
						s = s.replace(MAIN, main);
						s = s.replace(METHOD, method);
						s = s.replace(RTNTYPE, rtnType);
						s = s.replace(RTNNAME, rtnName);
						s = s.replace(PARA, para);
						s = s.replace(PUREPARA, purepara);
						s = s.replace(QUERY, query);
						r.writeBytes("\t" + s + separator);
						haveWrite = true;
					}
					if(haveWrite == true) {
						r.writeBytes("}");
						System.out.println("DONE!");
						r.close();
					}
				}				
			}			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(r != null) r.close();
				rt.close();
			} catch (java.io.IOException e) {
				e.printStackTrace();
			}
			
		}
			
//			r.writeUTF(s);
//			byte[] b = new byte[10240];
//			System.out.println(f.length());
//			
//			//r.read(b);
//			byte[] bb = new byte[2];
//			bb[0] = '2';
//			bb[1] = '8';
//			r.write(bb);
//			System.out.println(f.getCanonicalPath());
//			r.close();
//			System.out.println(new String(b));
//			byte[] bbb = new byte[10240];
//			r.read(bbb);
//			System.out.println(new String(bbb));
//			String s = "dsfsdfsdfd";
//			System.out.println(s.indexOf("d"));
//			InputStream inBuffer = null;   
//	        OutputStream outBuffer = null;   
//	        inBuffer = new BufferedInputStream(new FileInputStream(f));   
//	        outBuffer = new BufferedOutputStream(new FileOutputStream(f));   
//			InputStream i = new FileInputStream(f);
//			byte[] b = new byte[10240];
//			i.read(b);
//			OutputStream o = new FileOutputStream(f);
//			System.out.println(new String(b));
//			i.close();
//			o.close();
	
	}
	public static RandomAccessFile getAccessFile(String ctype,String main){
		if(ctype.equals("Action")) ctype = "action/" + "Admin" + "Action.java";
		else if(ctype.equals("IService")) ctype = "service/" + "I" + main + "Service";
		else if(ctype.equals("Service")) ctype = "service/" + main + "Service";
		else if(ctype.equals("IDao")) ctype = "dao/" + "I" + main + "Dao";
		else if(ctype.equals("Dao")) ctype = "dao/" + main + "Dao";
		else return null;
		try{
			File f1 = new File("");
			File f = new File(f1.getCanonicalPath() + "/src/cn/daijia/" + ctype + ".java");
			RandomAccessFile r = new RandomAccessFile(f,"rw");
			System.out.println(ctype);
			r.seek(f.length() - 3);
			r.writeBytes(separator + separator);
			return r;
		}catch(IOException e){
			e.printStackTrace();
			System.err.println("找不到文件!");
			return null;
		}	
	}
	
}
