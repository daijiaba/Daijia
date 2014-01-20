package cn.daijia.vo;

/**
 * ServicePrice entity. @author MyEclipse Persistence Tools
 */

public class ServicePrice implements java.io.Serializable {

	// Fields

	private Integer id;
	private String begindistrict;
	private String enddistrict;
	private Double baseprice;
	private String specialprice;
	private Double perhourprice;

	// Constructors

	/** default constructor */
	public ServicePrice() {
	}

	/** full constructor */
	public ServicePrice(String begindistrict, String enddistrict,
			Double baseprice, String specialprice, Double perhourprice) {
		this.begindistrict = begindistrict;
		this.enddistrict = enddistrict;
		this.baseprice = baseprice;
		this.specialprice = specialprice;
		this.perhourprice = perhourprice;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBegindistrict() {
		return this.begindistrict;
	}

	public void setBegindistrict(String begindistrict) {
		this.begindistrict = begindistrict;
	}

	public String getEnddistrict() {
		return this.enddistrict;
	}

	public void setEnddistrict(String enddistrict) {
		this.enddistrict = enddistrict;
	}

	public Double getBaseprice() {
		return this.baseprice;
	}

	public void setBaseprice(Double baseprice) {
		this.baseprice = baseprice;
	}

	public String getSpecialprice() {
		return this.specialprice;
	}

	public void setSpecialprice(String specialprice) {
		this.specialprice = specialprice;
	}

	public Double getPerhourprice() {
		return this.perhourprice;
	}

	public void setPerhourprice(Double perhourprice) {
		this.perhourprice = perhourprice;
	}

}