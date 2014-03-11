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
	private String setpasswdtime;
	private String lasttime;
	private Short frozen;

	// Constructors

	/** default constructor */
	public InfoAccount() {
	}

	/** minimal constructor */
	public InfoAccount(String passwd) {
		this.passwd = passwd;
	}

	/** full constructor */
	public InfoAccount(String passwd, String passwdfind, String passwdanswer,
			String setpasswdtime, String lasttime, Short frozen) {
		this.passwd = passwd;
		this.passwdfind = passwdfind;
		this.passwdanswer = passwdanswer;
		this.setpasswdtime = setpasswdtime;
		this.lasttime = lasttime;
		this.frozen = frozen;
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

	public String getSetpasswdtime() {
		return this.setpasswdtime;
	}

	public void setSetpasswdtime(String setpasswdtime) {
		this.setpasswdtime = setpasswdtime;
	}

	public String getLasttime() {
		return this.lasttime;
	}

	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}

	public Short getFrozen() {
		return this.frozen;
	}

	public void setFrozen(Short frozen) {
		this.frozen = frozen;
	}

}