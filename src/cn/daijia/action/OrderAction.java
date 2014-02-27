package cn.daijia.action;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.daijia.service.IOrderService;
import cn.daijia.service.ITestService;
import cn.daijia.vo.InfoDriver;
import cn.daijia.vo.StatusDriver;

@Controller
public class OrderAction extends ActionSupport{
	
	private String start;
	private String end;

//	private List<Content> result = new ArrayList<Content>();;
//	
//	public List<Content> getResult() {
//		return result;
//	}
//
//	public void setResult(List<Content> result) {
//		this.result = result;
//	}
	private Integer usernumber;
	private String usertel;
	private String username;
	private Integer drivingage;
	private Integer servicetimes;
	private Double length;
	
	
	public Integer getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(Integer usernumber) {
		this.usernumber = usernumber;
	}
	public String getUsertel() {
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getDrivingage() {
		return drivingage;
	}
	public void setDrivingage(Integer drivingage) {
		this.drivingage = drivingage;
	}
	public Integer getServicetimes() {
		return servicetimes;
	}
	public void setServicetimes(Integer servicetimes) {
		this.servicetimes = servicetimes;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	private String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
//	private JSONObject json;
	//	public void setJson(JSONObject json) {
//		this.json = json;
//	}
//
//	public JSONObject getJson() {
//		return json;
//	}
	@Resource
	private IOrderService orderService;
	
	public String getDriverStatus(){
		List<StatusDriver> driverList = orderService.getDriverStatus();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("driverList", driverList);
		StatusDriver sd = (StatusDriver)(driverList.get(0));
		System.out.println(sd.getLat()+" "+start+" "+end);
		String[] tmp = start.trim().split(",");
		double sLng = Double.valueOf(tmp[0]);
		double sLat = Double.valueOf(tmp[1]);
		length = getLength(sLng, sLat, sd.getLng(), sd.getLat());
		System.out.println(length);
		DecimalFormat df = new DecimalFormat("#.0");
		length = Double.valueOf(df.format(length));
		System.out.println(length);
		InfoDriver dri = sd.getInfoDriver();
		System.out.println(dri.getUsername());
//		JSONObject jsonTmp = new JSONObject();
//		jsonTmp.put("result", dri.getUsername());
		for(StatusDriver sTmp : driverList){
			if(sTmp.getStatus() != null && sTmp.getStatus() == true && sTmp.getBusyornot() != null && 
					sTmp.getBusyornot() == false){
				Content c = new Content();
				dri = sTmp.getInfoDriver();
				c.setDrivingage(dri.getDrivingage());
				c.setLength(length);
				c.setServicetimes(dri.getServicetimes());
				c.setUsername(dri.getUsername());
				c.setUsernumber(sTmp.getUsernumber());
				c.setUsertel(dri.getUsertel());
				drivingage = dri.getDrivingage();
				servicetimes = dri.getServicetimes();
				username = dri.getUsername();
				usernumber = sTmp.getUsernumber();
				usertel = dri.getUsertel();
				result = "success";
			}
		}
		return SUCCESS;
	}
	
	public double getLength(double a1,double a2,double b1,double b2){
		double length = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin((rad(a2)-rad(b2))/2), 2) + Math.cos(rad(a2)) * Math.cos(rad(b2)) * Math.pow(Math.sin(((rad(a1)-rad(b1))/2)),2)));
		length = length * 6378.137;
		return length;
	}
	public double rad(double d){
		return d * Math.PI/180.0;
	}
	
	public void setStart(String start) {
		this.start = start;
	}
	public void setEnd(String end) {
		this.end = end;
	}
//	public IOrderService getOrderService() {
//		return orderService;
//	}
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
}



class Content{
	private Integer usernumber;
	private String usertel;
	private String username;
	private Integer drivingage;
	private Integer servicetimes;
	private Double length;
	
	
	public Integer getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(Integer usernumber) {
		this.usernumber = usernumber;
	}
	public String getUsertel() {
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getDrivingage() {
		return drivingage;
	}
	public void setDrivingage(Integer drivingage) {
		this.drivingage = drivingage;
	}
	public Integer getServicetimes() {
		return servicetimes;
	}
	public void setServicetimes(Integer servicetimes) {
		this.servicetimes = servicetimes;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
}
