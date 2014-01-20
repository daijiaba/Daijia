package cn.daijia.vo;

/**
 * InfoCustomer entity. @author MyEclipse Persistence Tools
 */

public class InfoCustomer implements java.io.Serializable {

	// Fields

	private Integer usernumber;
	private String usertel;
	private String username;
	private String passwd;
	private String email;
	private String district;
	private String address;
	private String contact;
	private String contacttel;
	private String carmodel;
	private String carnumber;
	private String passwdfind;
	private String passwdanswer;

	// Constructors

	/** default constructor */
	public InfoCustomer() {
	}

	/** minimal constructor */
	public InfoCustomer(String usertel, String passwd) {
		this.usertel = usertel;
		this.passwd = passwd;
	}

	/** full constructor */
	public InfoCustomer(String usertel, String username, String passwd,
			String email, String district, String address, String contact,
			String contacttel, String carmodel, String carnumber,
			String passwdfind, String passwdanswer) {
		this.usertel = usertel;
		this.username = username;
		this.passwd = passwd;
		this.email = email;
		this.district = district;
		this.address = address;
		this.contact = contact;
		this.contacttel = contacttel;
		this.carmodel = carmodel;
		this.carnumber = carnumber;
		this.passwdfind = passwdfind;
		this.passwdanswer = passwdanswer;
	}

	// Property accessors

	public Integer getUsernumber() {
		return this.usernumber;
	}

	public void setUsernumber(Integer usernumber) {
		this.usernumber = usernumber;
	}

	public String getUsertel() {
		return this.usertel;
	}

	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContacttel() {
		return this.contacttel;
	}

	public void setContacttel(String contacttel) {
		this.contacttel = contacttel;
	}

	public String getCarmodel() {
		return this.carmodel;
	}

	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}

	public String getCarnumber() {
		return this.carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getPasswdfind() {
		return this.passwdfind;
	}

	public void setPasswdfind(String passwdfind) {
		this.passwdfind = passwdfind;
	}

	public String getPasswdanswer() {
		return this.passwdanswer;
	}

	public void setPasswdanswer(String passwdanswer) {
		this.passwdanswer = passwdanswer;
	}

}