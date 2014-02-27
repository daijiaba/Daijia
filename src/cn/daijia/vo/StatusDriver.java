package cn.daijia.vo;

/**
 * StatusDriver entity. @author MyEclipse Persistence Tools
 */

public class StatusDriver implements java.io.Serializable {

	// Fields

	private Integer usernumber;
	private Boolean busyornot;
	private Boolean status;
	private String location;
	private Double lng;
	private Double lat;
	private InfoDriver infoDriver;

	// Constructors

	/** default constructor */
	public StatusDriver() {
	}

	/** full constructor */
	public StatusDriver(Boolean busyornot, Boolean status, String location,
			Double lng, Double lat) {
		this.busyornot = busyornot;
		this.status = status;
		this.location = location;
		this.lng = lng;
		this.lat = lat;
	}

	// Property accessors

	public Integer getUsernumber() {
		return this.usernumber;
	}

	public void setUsernumber(Integer usernumber) {
		this.usernumber = usernumber;
	}

	public Boolean getBusyornot() {
		return this.busyornot;
	}

	public void setBusyornot(Boolean busyornot) {
		this.busyornot = busyornot;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getLng() {
		return this.lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return this.lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}
	
	public InfoDriver getInfoDriver() {
		return infoDriver;
	}

	public void setInfoDriver(InfoDriver infoDriver) {
		this.infoDriver = infoDriver;
	}

}