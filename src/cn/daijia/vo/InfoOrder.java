package cn.daijia.vo;

/**
 * InfoOrder entity. @author MyEclipse Persistence Tools
 */

public class InfoOrder implements java.io.Serializable {

	// Fields

	private Integer ordernumber;
	private Integer CUsernumber;
	private Integer DUsernumber;
	private String CUsertel;
	private String DUsertel;
	private String ordertime;
	private String begintime;
	private String endtime;
	private String beginlocation;
	private String endlocation;
	private Short status;
	private String processtime;
	private InfoOrderPay infoOrderPay;

	// Constructors

	/** default constructor */
	public InfoOrder() {
	}

	/** minimal constructor */
	public InfoOrder(Integer CUsernumber, Integer DUsernumber, String CUsertel,
			String ordertime) {
		this.CUsernumber = CUsernumber;
		this.DUsernumber = DUsernumber;
		this.CUsertel = CUsertel;
		this.ordertime = ordertime;
	}

	/** full constructor */
	public InfoOrder(Integer CUsernumber, Integer DUsernumber, String CUsertel,
			String DUsertel, String ordertime, String begintime,
			String endtime, String beginlocation, String endlocation,
			Short status, String processtime, InfoOrderPay infoOrderPay) {
		this.CUsernumber = CUsernumber;
		this.DUsernumber = DUsernumber;
		this.CUsertel = CUsertel;
		this.DUsertel = DUsertel;
		this.ordertime = ordertime;
		this.begintime = begintime;
		this.endtime = endtime;
		this.beginlocation = beginlocation;
		this.endlocation = endlocation;
		this.status = status;
		this.processtime = processtime;
		this.infoOrderPay = infoOrderPay;
	}

	// Property accessors

	public Integer getOrdernumber() {
		return this.ordernumber;
	}

	public void setOrdernumber(Integer ordernumber) {
		this.ordernumber = ordernumber;
	}

	public Integer getCUsernumber() {
		return this.CUsernumber;
	}

	public void setCUsernumber(Integer CUsernumber) {
		this.CUsernumber = CUsernumber;
	}

	public Integer getDUsernumber() {
		return this.DUsernumber;
	}

	public void setDUsernumber(Integer DUsernumber) {
		this.DUsernumber = DUsernumber;
	}

	public String getCUsertel() {
		return this.CUsertel;
	}

	public void setCUsertel(String CUsertel) {
		this.CUsertel = CUsertel;
	}

	public String getDUsertel() {
		return this.DUsertel;
	}

	public void setDUsertel(String DUsertel) {
		this.DUsertel = DUsertel;
	}

	public String getOrdertime() {
		return this.ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public String getBegintime() {
		return this.begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getBeginlocation() {
		return this.beginlocation;
	}

	public void setBeginlocation(String beginlocation) {
		this.beginlocation = beginlocation;
	}

	public String getEndlocation() {
		return this.endlocation;
	}

	public void setEndlocation(String endlocation) {
		this.endlocation = endlocation;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getProcesstime() {
		return this.processtime;
	}

	public void setProcesstime(String processtime) {
		this.processtime = processtime;
	}

	public InfoOrderPay getInfoOrderPay() {
		return this.infoOrderPay;
	}

	public void setInfoOrderPay(InfoOrderPay infoOrderPay) {
		this.infoOrderPay = infoOrderPay;
	}

}