package cn.daijia.vo;

/**
 * InfoCD entity. @author MyEclipse Persistence Tools
 */

public class InfoCD implements java.io.Serializable {

	// Fields

	private Integer tradeid;
	private Integer usernumber;
	private Short status;
	private Double payamount;
	private String paytime;
	private Double accountbalance;
	private Integer ordernumber;
	private String remark;
	private InfoOrder infoOrder;

	// Constructors

	/** default constructor */
	public InfoCD() {
	}

	/** minimal constructor */
	public InfoCD(Integer usernumber, Short status) {
		this.usernumber = usernumber;
		this.status = status;
	}

	/** full constructor */
	public InfoCD(Integer usernumber, Short status, Double payamount,
			String paytime, Double accountbalance, Integer ordernumber,
			String remark) {
		this.usernumber = usernumber;
		this.status = status;
		this.payamount = payamount;
		this.paytime = paytime;
		this.accountbalance = accountbalance;
		this.ordernumber = ordernumber;
		this.remark = remark;
	}

	// Property accessors

	public Integer getTradeid() {
		return this.tradeid;
	}

	public void setTradeid(Integer tradeid) {
		this.tradeid = tradeid;
	}

	public Integer getUsernumber() {
		return this.usernumber;
	}

	public void setUsernumber(Integer usernumber) {
		this.usernumber = usernumber;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Double getPayamount() {
		return this.payamount;
	}

	public void setPayamount(Double payamount) {
		this.payamount = payamount;
	}

	public String getPaytime() {
		return this.paytime;
	}

	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}

	public Double getAccountbalance() {
		return this.accountbalance;
	}

	public void setAccountbalance(Double accountbalance) {
		this.accountbalance = accountbalance;
	}

	public Integer getOrdernumber() {
		return this.ordernumber;
	}

	public void setOrdernumber(Integer ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public InfoOrder getInfoOrder() {
		return infoOrder;
	}

	public void setInfoOrder(InfoOrder infoOrder) {
		this.infoOrder = infoOrder;
	}
	

}