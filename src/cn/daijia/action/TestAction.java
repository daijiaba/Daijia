package cn.daijia.action;


import javax.annotation.Resource;
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
		System.out.println(infoCustomer.getPasswd() + "--------------------");
		testService.saveInfoCustomer(infoCustomer);
		return SUCCESS;
	}

}
