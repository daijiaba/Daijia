package cn.daijia.vo;

/**
 * InfoAccount entity. @author MyEclipse Persistence Tools
 */

public class InfoAccount implements java.io.Serializable {

	// Fields

	private Integer usernumber;
	private String passwd;
	private String passwdfind;
	private String passwdanswer;

	// Constructors

	/** default constructor */
	public InfoAccount() {
	}

	/** minimal constructor */
	public InfoAccount(String passwd) {
		this.passwd = passwd;
	}

	/** full constructor */
	public InfoAccount(String passwd, String passwdfind, String passwdanswer) {
		this.passwd = passwd;
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

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
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