package cn.daijia.action;

import java.util.List;
import java.util.Map;
import cn.daijia.service.IInfoOrderService;
import cn.daijia.vo.InfoOrder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class InfoOrderAction extends ActionSupport{
	public InfoOrder infoOrder;
	public static IInfoOrderService infoOrderService;
	public Integer ordernumber;
	public String ordertime;
	public Short status;
	public String DUsertel;
	public String beginlocation;
	
	public String searchOrder(){
		StringBuffer hql=new StringBuffer("from InfoOrder ifo where 1=1 ");
		if(ordernumber!=null&&ordernumber.SIZE!=0)
			hql.append(" and ifo.ordernumber = "+ordernumber);
	    if(ordertime!=null&&ordertime.length()!=0)
			hql.append(" and ifo.ordertime = "+ordertime);
		if(status!=null&&status.SIZE!=0)
			hql.append(" and ifo.status = "+status);
		if(DUsertel!=null&&DUsertel.length()!=0)
			hql.append(" and ifo.DUsertel = "+DUsertel);
		if(beginlocation!=null&&beginlocation.length()!=0)
			hql.append(" and ifo.beginlocation like '%"+beginlocation+"%'");
		List order=infoOrderService.searchInfoOrder(hql.toString());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("orders", order);
		return SUCCESS;
	}
	public String allOrder(){
		List allorders=infoOrderService.getAllIfoOrder();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("allorder", allorders);
		return SUCCESS;
	}
	public InfoOrder searchOrderByOrdernumber(Integer ordernumber){
		InfoOrder ifo=infoOrderService.getOrderByOrdernumber(ordernumber);
		return ifo;
		
	}
	
	
	public InfoOrder getInfoOrder() {
		return infoOrder;
	}
	public void setInfoOrder(InfoOrder infoOrder) {
		this.infoOrder = infoOrder;
	}
	public IInfoOrderService getInfoOrderService() {
		return infoOrderService;
	}
	public void setInfoOrderService(IInfoOrderService infoOrderService) {
		this.infoOrderService = infoOrderService;
	}
	public Integer getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(Integer ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public String getDUsertel() {
		return DUsertel;
	}
	public void setDUsertel(String dUsertel) {
		DUsertel = dUsertel;
	}

}
