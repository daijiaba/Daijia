package cn.daijia.action;

import java.util.Map;
import cn.daijia.service.IInfoCustomerService;
import cn.daijia.service.InfoCustomerService;
import cn.daijia.vo.InfoCustomer;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class InfoCustomerAction extends ActionSupport{
	protected InfoCustomer infoCustomer;
	protected IInfoCustomerService infoCustomerService;
	
	public InfoCustomer getInfoCustomer() {
		return infoCustomer;
	}
	public void setInfoCustomer(InfoCustomer infoCustomer) {
		this.infoCustomer = infoCustomer;
	}
	public IInfoCustomerService getInfoCustomerService() {
		return infoCustomerService;
	}
	public void setInfoCustomerService(IInfoCustomerService infoCustomerService) {
		this.infoCustomerService = infoCustomerService;
	}
	
	public String validateUser(){
		InfoCustomer ifc=infoCustomerService.validateInfoCustomer(infoCustomer.getUsername(), infoCustomer.getPasswd());
		if(ifc!=null){
			Map session=ActionContext.getContext().getSession();
			session.put("infoCustomer", ifc);
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	

}
