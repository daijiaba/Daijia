package cn.daijia.action;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Map;
import cn.daijia.service.IInfoCDService;
import cn.daijia.service.IInfoCustomerService;
import cn.daijia.vo.InfoCD;
import cn.daijia.vo.InfoOrder;
import cn.daijia.vo.InfoCustomer;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class InfoCDAction extends ActionSupport{
	protected InfoCD infoCD;
	public InfoCustomer infoCustomer;
	public IInfoCDService infoCDService;
	public IInfoCustomerService infoCustomerService; 
	protected Short status;
	protected String paytime;
	protected Integer usernumber;
	protected Integer unumber;
	protected Double payamount;
	protected Double accountbalance;
	protected Integer ordernumber;
	protected Short orderstatus;
	public String time1;
	public String time2;
	public String usertel;
	
	public String searchCD(){
		StringBuffer hql=new StringBuffer("from InfoCD ifcd where ");
		if(unumber!=null&&unumber.SIZE!=0)
			hql.append("ifcd.usernumber="+unumber);
		InfoCD infoCDs=infoCDService.searchInfoCD(hql.toString());
		Map session=ActionContext.getContext().getSession();
		if(infoCDs==null){
			Double acutbalance=0.0;
			InfoCD ifcd=new InfoCD();
			ifcd.setAccountbalance(acutbalance);
			session.put("ifCD", ifcd);
			return SUCCESS;
		}
		session.put("ifCD", infoCDs);
	    return SUCCESS;
	}
	
	public String saveInfoCD(){
		status=1;
		Date date=new Date();
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    paytime=sdf.format(date);
	    String remark="存入";
	    accountbalance=infoCD.getAccountbalance();
	    payamount=infoCD.getPayamount();
	    accountbalance+=payamount;
	    infoCD.setAccountbalance(accountbalance);
		infoCD.setStatus(status);
		infoCD.setPaytime(paytime);
		infoCD.setRemark(remark);
		infoCDService.saveInfoCD(infoCD);
		return SUCCESS;
	}
	
	public String getAllCD(){
		List ifos=infoCDService.getAllInfoCD();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("ifos", ifos);
		return SUCCESS;
	}
	
	public String searchCDByHql(){
		StringBuffer hql=new StringBuffer("from InfoCD ifc where 1=1 ");
		if(ordernumber!=null&&ordernumber.SIZE!=0)
			hql.append(" and ifc.ordernumber = "+ordernumber);
	    if(paytime!=null&&paytime.length()!=0){
	    	Date date=new Date();
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		    String now=sdf.format(date);
	    	Calendar cal=Calendar.getInstance();
			cal.setTime(date);
			int num=Integer.parseInt(paytime);
			cal.add(cal.DATE,-num);
			Date later=cal.getTime();
			String time=sdf.format(later);
			hql.append(" and ifc.paytime between '"+time+"' and '"+now+"'");
	    }
		if(status!=null&&status.SIZE!=0)
			hql.append(" and ifc.status = "+status);
		if(orderstatus!=null&&orderstatus.SIZE!=0)
			hql.append(" and ifc.infoOrder.status = "+orderstatus);
		List cd=infoCDService.searchInfoCDByHql(hql.toString());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("cds",cd);
		return SUCCESS;
	}
	
	public String searchCDForAccount(){
		StringBuffer hql=new StringBuffer("from InfoCD ifc where 1=1 ");
		if(usernumber!=null&&usernumber.SIZE!=0)
			hql.append(" and ifc.usernumber = "+usernumber);
		if(time1!=null&&time1.length()!=0&&time2!=null&&time2.length()!=0)
			hql.append(" and ifc.paytime between '"+time1+"' and '"+time2+"'");
		if(status!=null&&status.SIZE!=0)
			hql.append(" and ifc.status = "+status);
		List accountcds=infoCDService.searchInfoCDByHql(hql.toString());
		double count0=0;
		double count1=0;
		InfoCD infocd;
		for(int i=0;i<accountcds.size();i++){
			infocd=(InfoCD)accountcds.get(i);
			if(infocd.getStatus()==0)
			   count0=infocd.getPayamount()+count0;
			else if(infocd.getStatus()==1) 
				count1=infocd.getPayamount()+count1;
		}
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("count0",count0);
		request.put("count1",count1);
		request.put("accountcds",accountcds);
		return SUCCESS;
	}
	
	public String accountTransfer(){
		status=0;
		Date date=new Date();
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    paytime=sdf.format(date);
	    String remark="转出";
	    accountbalance=infoCD.getAccountbalance();
	    payamount=infoCD.getPayamount();
	    accountbalance-=payamount;
	    if(accountbalance<0){
	    	return ERROR;
	    }
	    else{
	        infoCD.setAccountbalance(accountbalance);
		    infoCD.setStatus(status);
		    infoCD.setPaytime(paytime);
		    infoCD.setRemark(remark);
		    infoCDService.saveInfoCD(infoCD);

		    usertel=infoCustomer.getUsertel();
		    Integer number=infoCustomerService.getUserByUsertel(usertel).getUsernumber();
		    StringBuffer hql=new StringBuffer("from InfoCD ifcd where ifcd.usernumber="+number);
		    InfoCD CD=infoCDService.searchInfoCD(hql.toString());
		    double balance=CD.getAccountbalance();
		    status=1;
	        remark="转入";
	        balance+=payamount;
	        InfoCD infocd=new InfoCD();
	        infocd.setUsernumber(number);
	        infocd.setPayamount(payamount);
	        infocd.setAccountbalance(balance);
		    infocd.setStatus(status);
		    infocd.setPaytime(paytime);
		    infocd.setRemark(remark);
		    infoCDService.saveInfoCD(infocd);
		    return SUCCESS;
	    }
	}
	
	public InfoCD getInfoCD() {
		return infoCD;
	}

	public void setInfoCD(InfoCD infoCD) {
		this.infoCD = infoCD;
	}

	public IInfoCDService getInfoCDService() {
		return infoCDService;
	}

	public void setInfoCDService(IInfoCDService infoCDService) {
		this.infoCDService = infoCDService;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getPaytime() {
		return paytime;
	}

	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}

	public Integer getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(Integer usernumber) {
		this.usernumber = usernumber;
	}

	public Double getPayamount() {
		return payamount;
	}

	public void setPayamount(Double payamount) {
		this.payamount = payamount;
	}

	public Integer getUnumber() {
		return unumber;
	}

	public void setUnumber(Integer unumber) {
		this.unumber = unumber;
	}

	public Integer getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(Integer ordernumber) {
		this.ordernumber = ordernumber;
	}

	public Short getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(Short orderstatus) {
		this.orderstatus = orderstatus;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getUsertel() {
		return usertel;
	}

	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}

	public IInfoCustomerService getInfoCustomerService() {
		return infoCustomerService;
	}

	public void setInfoCustomerService(IInfoCustomerService infoCustomerService) {
		this.infoCustomerService = infoCustomerService;
	}

	public InfoCustomer getInfoCustomer() {
		return infoCustomer;
	}

	public void setInfoCustomer(InfoCustomer infoCustomer) {
		this.infoCustomer = infoCustomer;
	}
	
	
}
