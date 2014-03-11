package cn.daijia.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import cn.daijia.util.MailSenderInfo;
import cn.daijia.util.SimpleMailSender;
import cn.daijia.vo.InfoAccount;
import cn.daijia.vo.InfoCustomer;
import cn.daijia.service.IInfoAccountService;
import cn.daijia.service.IInfoCustomerService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class InfoAccountAction extends ActionSupport{
	public InfoAccount infoAccount;
	public InfoCustomer infoCustomer;
	public IInfoAccountService infoAccountService;
	public IInfoCustomerService infoCustomerService; 
	public Integer usernumber;
	public String passwd;
    public String newPasswd;
    public String passwdfind;
    public String passwdanswer;
    public Short frozen;
    public String email;
    
	public String saveAccount(){
		Date date=new Date();
		frozen=1;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String setpasswdtime=sdf.format(date);
		infoAccount.setSetpasswdtime(setpasswdtime);
		infoAccount.setFrozen(frozen);
		infoAccountService.saveAccount(infoAccount);
		return SUCCESS;
	}
	public String getAccount(){
		 InfoAccount ifa=infoAccountService.getAccount(usernumber);
		 if(ifa.getFrozen()==0){
			 return ERROR;
		 }
		 Map session=ActionContext.getContext().getSession();
		 session.put("ifa", ifa);
		 return SUCCESS;
		
	}
	public String saveTime(){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lastTime=sdf.format(date);
		StringBuffer hql=new StringBuffer("update InfoAccount ifa set ifa.lasttime ="+lastTime+" where ifa.usernumber = "+usernumber);
		infoAccountService.updateAccount(hql.toString());
		return SUCCESS;
	}
	public String editPasswd(){
		StringBuffer hql=new StringBuffer("update InfoAccount ifa set ifa.passwd ="+newPasswd+" where ifa.usernumber = "+usernumber);
		infoAccountService.updateAccount(hql.toString());
		return SUCCESS;
	}
	public String editQuestion(){
		StringBuffer hql=new StringBuffer("update InfoAccount ifa set ifa.passwdfind ='"+passwdfind+"', ifa.passwdanswer = '"+passwdanswer+"' where ifa.usernumber = "+usernumber);
		infoAccountService.updateAccount(hql.toString());
		return SUCCESS;
	}
	public String passwdFind(){
		email=infoCustomer.getEmail();
		String rCheckEmali ="^\\w+@[a-z0-9]+\\.[a-z]+$";
		String rCheckTel="^1[0-9]{10}$";
		StringBuffer hql=new StringBuffer("from InfoCustomer ifc where 1=1 ");
	    if(email.matches(rCheckEmali)){
	    	hql.append(" and ifc.email='"+email+"'");
	    }
	    if(email.matches(rCheckTel)){
	    	hql.append(" and ifc.usertel='"+email+"'");
		}
		hql.append(" and ifc.usernumber="+usernumber);
		InfoCustomer ifcus=infoCustomerService.getUserByEmail(hql.toString());
		if(ifcus!=null){
			 //设置邮件   
		     MailSenderInfo mailInfo = new MailSenderInfo();    
		     mailInfo.setMailServerHost("smtp.163.com");    
		     mailInfo.setMailServerPort("25");    
		     mailInfo.setValidate(true);    
		     mailInfo.setUserName("zch624228@163.com");    
		     mailInfo.setPassword("s1361672793");//邮箱密码    
		     mailInfo.setFromAddress("zch624228@163.com");    
		     mailInfo.setToAddress(email);    
		     mailInfo.setSubject("代驾网更改密码设置");    
		     mailInfo.setContent("请您单击链接，进行密码的重新设置<a href=\"http://localhost:8080/Daijia/accountpasswdedit.jsp\">http://124.168.128.116/1273879879/findpasswd.jsp</a>");    
		        //发送邮件   
		     SimpleMailSender sms = new SimpleMailSender();     
		     sms.sendHtmlMail(mailInfo);//发送html格式   
			return SUCCESS;
		}
		else
		    return ERROR;
	}
	public String findEmail(){
		email=infoCustomer.getEmail();
		String rCheckEmali ="^\\w+@[a-z0-9]+\\.[a-z]+$";
		String rCheckTel="^1[0-9]{10}$";
		StringBuffer hql=new StringBuffer("from InfoCustomer ifc where 1=1 ");
	    if(email.matches(rCheckEmali)){
	    	hql.append(" and ifc.email='"+email+"'");
	    }
	    if(email.matches(rCheckTel)){
	    	hql.append(" and ifc.usertel='"+email+"'");
		}
		hql.append(" and ifc.usernumber="+usernumber);
		InfoCustomer ifcus=infoCustomerService.getUserByEmail(hql.toString());
		if(ifcus!=null)
			return SUCCESS;
		return ERROR;
	}
	public String passwdFindByQuestion(){
		StringBuffer hql=new StringBuffer("from InfoAccount ifa where ifa.passwdfind='"+passwdfind+"' and ifa.passwdanswer='"+passwdanswer+"' and ifa.usernumber="+usernumber);
		InfoAccount infoaccount=infoAccountService.getAccountByQuestion(hql.toString());
		if(infoaccount!=null){
		     MailSenderInfo mailInfo = new MailSenderInfo();    
		     mailInfo.setMailServerHost("smtp.163.com");    
		     mailInfo.setMailServerPort("25");    
		     mailInfo.setValidate(true);    
		     mailInfo.setUserName("zch624228@163.com");    
		     mailInfo.setPassword("s1361672793");
		     mailInfo.setFromAddress("zch624228@163.com");    
		     mailInfo.setToAddress(email);    
		     mailInfo.setSubject("代驾网更改密码设置");    
		     mailInfo.setContent("请您单击链接，进行密码的重新设置<a href=\"http://localhost:8080/Daijia/accountpasswdedit.jsp\">http://124.168.128.116/1273879879/findpasswd.jsp</a>");    
		     SimpleMailSender sms = new SimpleMailSender();     
		     sms.sendHtmlMail(mailInfo);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public InfoAccount getInfoAccount() {
		return infoAccount;
	}
	public void setInfoAccount(InfoAccount infoAccount) {
		this.infoAccount = infoAccount;
	}
	public IInfoAccountService getInfoAccountService() {
		return infoAccountService;
	}
	public void setInfoAccountService(IInfoAccountService infoAccountService) {
		this.infoAccountService = infoAccountService;
	}
	public Integer getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(Integer usernumber) {
		this.usernumber = usernumber;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getNewPasswd() {
		return newPasswd;
	}
	public void setNewPasswd(String newPasswd) {
		this.newPasswd = newPasswd;
	}
	public String getPasswdfind() {
		return passwdfind;
	}
	public void setPasswdfind(String passwdfind) {
		this.passwdfind = passwdfind;
	}
	public String getPasswdanswer() {
		return passwdanswer;
	}
	public void setPasswdanswer(String passwdanswer) {
		this.passwdanswer = passwdanswer;
	}
    
	public IInfoCustomerService getInfoCustomerService() {
		return infoCustomerService;
	}
	public void setInfoCustomerService(IInfoCustomerService infoCustomerService) {
		this.infoCustomerService = infoCustomerService;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public InfoCustomer getInfoCustomer() {
		return infoCustomer;
	}
	public void setInfoCustomer(InfoCustomer infoCustomer) {
		this.infoCustomer = infoCustomer;
	}
	

}
