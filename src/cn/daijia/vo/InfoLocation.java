package cn.daijia.vo;

/**
 * InfoLocation entity. @author MyEclipse Persistence Tools
 */

public class InfoLocation implements java.io.Serializable {

	// Fields

	private Integer locationnumber;
	private String district;
	private String street;

	// Constructors

	/** default constructor */
	public InfoLocation() {
	}

	/** full constructor */
	public InfoLocation(String district, String street) {
		this.district = district;
		this.street = street;
	}

	// Property accessors

	public Integer getLocationnumber() {
		return this.locationnumber;
	}

	public void setLocationnumber(Integer locationnumber) {
		this.locationnumber = locationnumber;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}