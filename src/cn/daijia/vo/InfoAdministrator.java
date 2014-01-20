package cn.daijia.vo;

/**
 * InfoAdministrator entity. @author MyEclipse Persistence Tools
 */

public class InfoAdministrator implements java.io.Serializable {

	// Fields

	private String usernumber;
	private String passwd;
	private Boolean usertype;
	private String username;
	private String sex;
	private String idcard;
	private String usertel;
	private String address;
	private String email;
	private String passwdfind;
	private String passwdanswer;

	// Constructors

	/** default constructor */
	public InfoAdministrator() {
	}

	/** minimal constructor */
	public InfoAdministrator(String passwd, Boolean usertype, String username,
			String sex, String idcard, String usertel) {
		this.passwd = passwd;
		this.usertype = usertype;
		this.username = username;
		this.sex = sex;
		this.idcard = idcard;
		this.usertel = usertel;
	}

	/** full constructor */
	public InfoAdministrator(String passwd, Boolean usertype, String username,
			String sex, String idcard, String usertel, String address,
			String email, String passwdfind, String passwdanswer) {
		this.passwd = passwd;
		this.usertype = usertype;
		this.username = username;
		this.sex = sex;
		this.idcard = idcard;
		this.usertel = usertel;
		this.address = address;
		this.email = email;
		this.passwdfind = passwdfind;
		this.passwdanswer = passwdanswer;
	}

	// Property accessors

	public String getUsernumber() {
		return this.usernumber;
	}

	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Boolean getUsertype() {
		return this.usertype;
	}

	public void setUsertype(Boolean usertype) {
		this.usertype = usertype;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getUsertel() {
		return this.usertel;
	}

	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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