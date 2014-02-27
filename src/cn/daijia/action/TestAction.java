package cn.daijia.action;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.RequestMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.daijia.service.ITestService;
import cn.daijia.vo.InfoCustomer;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class TestAction extends ActionSupport{
	@Resource
	private ITestService testService;
	private InfoCustomer infoCustomer;
	private String passwd;

	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public InfoCustomer getInfoCustomer() {
		return infoCustomer;
	}
	public void setInfoCustomer(InfoCustomer infoCustomer) {
		this.infoCustomer = infoCustomer;
	}
	public ITestService getTestService() {
		return testService;
	}
	public void setTestService(ITestService testService) {
		this.testService = testService;
	}	
	
	public String saveInfoCustomer(){
		HttpServletRequest req = ServletActionContext.getRequest();
        path = req.getRequestURI().substring(12);
        String queryString = req.getQueryString();
        if (queryString == null) {
            queryString = "";
        }
        path += "?" + queryString;
        System.out.println(path);
        
			tips = "false";
			return "false";
			//return "false";

		
		//System.out.println(infoCustomer.getPasswd() + "--------------------");
		//testService.saveInfoCustomer(infoCustomer);
		//String path = "/test.jsp";//ServletActionContext.getRequest().getServletPath().toString();
		//return SUCCESS;
	}
	
	private String path;
	private String tips = "";	
	public String getPath(){
		return path;
	}	
	public void setPath(String path) {
		this.path = path;
	}
	public String getTips() {
		return tips;
	}
}
