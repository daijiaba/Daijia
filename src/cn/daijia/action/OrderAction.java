package cn.daijia.action;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
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
	private String usernumber;
	private String usertel;
	private String username;
	private String drivingage;
	private String servicetimes;
	private String length;
	private double selength;
	private String result;
	private double qiMoney;
	private double guMoney;
	private String startPlace;
	private String endPlace;
	private String autoType;
	
	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getEndPlace() {
		return endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}

	public String getAutoType() {
		return autoType;
	}

	public void setAutoType(String autoType) {
		this.autoType = autoType;
	}

	public void setSelength(double selength) {
		this.selength = selength;
	}

	public void setQiMoney(double qiMoney) {
		this.qiMoney = qiMoney;
	}

	public void setGuMoney(double guMoney) {
		this.guMoney = guMoney;
	}

	public double getGuMoney() {
		return guMoney;
	}
	
	public double getQiMoney() {
		return qiMoney;
	}
	
	public double getSelength() {
		return selength;
	}
	
	public String getUsernumber() {
		return usernumber;
	}

	public String getUsertel() {
		return usertel;
	}

	public String getUsername() {
		return username;
	}

	public String getDrivingage() {
		return drivingage;
	}

	public String getServicetimes() {
		return servicetimes;
	}

	public String getLength() {
		return length;
	}

	public String getResult() {
		return result;
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
		System.out.println(driverList.size() + "---------------------");
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("driverList", driverList);
		StatusDriver sd = (StatusDriver)(driverList.get(0));
		System.out.println(sd.getLat()+" "+start+" "+end);
		String[] s_tmp = start.trim().split(",");
		String[] e_tmp = end.trim().split(",");
		double sLng = Double.valueOf(s_tmp[0]);
		double sLat = Double.valueOf(s_tmp[1]);
		double eLng = Double.valueOf(e_tmp[0]);
		double eLat = Double.valueOf(e_tmp[1]);
		selength = getLength(sLng, sLat, eLng, eLat);
		Date date = new Date();
		int hour = date.getHours();
		if(hour >= 7 && hour <= 21){
			qiMoney = 49;
		} else if(hour > 21 && hour <= 23){
			qiMoney = 69;
		} else{
			qiMoney = 99;
		}
		if(selength <= 10){
			guMoney = qiMoney;
		}
		double d = selength;
		for(guMoney = qiMoney ; d > 10 ; d-=10,guMoney += 20);
		
		DecimalFormat df = new DecimalFormat("#.0");
		selength = Double.valueOf(df.format(selength));
		
//		JSONObject jsonTmp = new JSONObject();
//		jsonTmp.put("result", dri.getUsername());
		
		
//		Integer usernumber1;
//		String usertel;
//		String username;
//		Integer drivingage;
//		Integer servicetimes;
		Double length1;
//		String result;
		usernumber = "";
		usertel = "";
		username = "";
		drivingage = "";
		servicetimes = "";
		length = "";
		result = "";
		for(StatusDriver sTmp : driverList){
			if(sTmp.getStatus() != null && sTmp.getStatus() == true && sTmp.getBusyornot() != null && 
					sTmp.getBusyornot() == false){
				
				length1 = getLength(sLng, sLat, sTmp.getLng(), sTmp.getLat());
				System.out.println(length);
				df = new DecimalFormat("#.0");
				length1 = Double.valueOf(df.format(length1));
				length += length1.toString() + "|";
				System.out.println(length);
				InfoDriver dri = sTmp.getInfoDriver();
				System.out.println(dri.getUsername());
				
				
//				Content c = new Content();
//				dri = sTmp.getInfoDriver();
//				c.setDrivingage(dri.getDrivingage());
//				c.setLength(length);
//				c.setServicetimes(dri.getServicetimes());
//				c.setUsername(dri.getUsername());
//				c.setUsernumber(sTmp.getUsernumber());
//				c.setUsertel(dri.getUsertel());
				drivingage += dri.getDrivingage().toString() + "|";
				servicetimes += "0".toString() + "|";
				username += dri.getUsername() + "|";
				usernumber += sTmp.getUsernumber().toString() + "|";
				usertel += dri.getUsertel() + "|";
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
	
	
	public String pay(){
		return "pay";
	}
	
	public void confirm(){
		File f = new File("c:\\is.txt");
		try {
			f.createNewFile();
			System.out.println("asds--------------");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
