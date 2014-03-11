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

	// Constructors

	/** default constructor */
	public StatusDriver() {
	}

	/** full constructor */
	public StatusDriver(Boolean busyornot, Boolean status, String location) {
		this.busyornot = busyornot;
		this.status = status;
		this.location = location;
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

}