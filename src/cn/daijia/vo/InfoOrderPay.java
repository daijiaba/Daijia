package cn.daijia.vo;

/**
 * InfoOrderPay entity. @author MyEclipse Persistence Tools
 */

public class InfoOrderPay implements java.io.Serializable {

	// Fields

	private Integer ordernumber;
	private InfoOrder infoOrder;
	private Double payamount;
	private String advancepaytime;
	private String confirmpaytime;

	// Constructors

	/** default constructor */
	public InfoOrderPay() {
	}

	/** minimal constructor */
	public InfoOrderPay(InfoOrder infoOrder) {
		this.infoOrder = infoOrder;
	}

	/** full constructor */
	public InfoOrderPay(InfoOrder infoOrder, Double payamount,
			String advancepaytime, String confirmpaytime) {
		this.infoOrder = infoOrder;
		this.payamount = payamount;
		this.advancepaytime = advancepaytime;
		this.confirmpaytime = confirmpaytime;
	}

	// Property accessors

	public Integer getOrdernumber() {
		return this.ordernumber;
	}

	public void setOrdernumber(Integer ordernumber) {
		this.ordernumber = ordernumber;
	}

	public InfoOrder getInfoOrder() {
		return this.infoOrder;
	}

	public void setInfoOrder(InfoOrder infoOrder) {
		this.infoOrder = infoOrder;
	}

	public Double getPayamount() {
		return this.payamount;
	}

	public void setPayamount(Double payamount) {
		this.payamount = payamount;
	}

	public String getAdvancepaytime() {
		return this.advancepaytime;
	}

	public void setAdvancepaytime(String advancepaytime) {
		this.advancepaytime = advancepaytime;
	}

	public String getConfirmpaytime() {
		return this.confirmpaytime;
	}

	public void setConfirmpaytime(String confirmpaytime) {
		this.confirmpaytime = confirmpaytime;
	}

}