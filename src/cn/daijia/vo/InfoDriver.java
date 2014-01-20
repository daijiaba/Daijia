package cn.daijia.vo;

/**
 * InfoDriver entity. @author MyEclipse Persistence Tools
 */

public class InfoDriver implements java.io.Serializable {

	// Fields

	private Integer usernumber;
	private String usertel;
	private String employeeid;
	private String username;
	private String sex;
	private String idcard;
	private String licensetype;
	private String lowerlimit;
	private String upperlimit;
	private Integer drivingage;
	private String licensecopy;
	private String photo;
	private String contact;
	private String contacttel;
	private Integer servicetimes;
	private String servicegrade;
	private String passwdfind;
	private String passwdanswer;

	// Constructors

	/** default constructor */
	public InfoDriver() {
	}

	/** minimal constructor */
	public InfoDriver(String usertel, String username, String sex,
			String idcard, String licensetype, String lowerlimit,
			String upperlimit, Integer drivingage, String licensecopy) {
		this.usertel = usertel;
		this.username = username;
		this.sex = sex;
		this.idcard = idcard;
		this.licensetype = licensetype;
		this.lowerlimit = lowerlimit;
		this.upperlimit = upperlimit;
		this.drivingage = drivingage;
		this.licensecopy = licensecopy;
	}

	/** full constructor */
	public InfoDriver(String usertel, String employeeid, String username,
			String sex, String idcard, String licensetype, String lowerlimit,
			String upperlimit, Integer drivingage, String licensecopy,
			String photo, String contact, String contacttel,
			Integer servicetimes, String servicegrade, String passwdfind,
			String passwdanswer) {
		this.usertel = usertel;
		this.employeeid = employeeid;
		this.username = username;
		this.sex = sex;
		this.idcard = idcard;
		this.licensetype = licensetype;
		this.lowerlimit = lowerlimit;
		this.upperlimit = upperlimit;
		this.drivingage = drivingage;
		this.licensecopy = licensecopy;
		this.photo = photo;
		this.contact = contact;
		this.contacttel = contacttel;
		this.servicetimes = servicetimes;
		this.servicegrade = servicegrade;
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

	public String getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
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

	public String getLicensetype() {
		return this.licensetype;
	}

	public void setLicensetype(String licensetype) {
		this.licensetype = licensetype;
	}

	public String getLowerlimit() {
		return this.lowerlimit;
	}

	public void setLowerlimit(String lowerlimit) {
		this.lowerlimit = lowerlimit;
	}

	public String getUpperlimit() {
		return this.upperlimit;
	}

	public void setUpperlimit(String upperlimit) {
		this.upperlimit = upperlimit;
	}

	public Integer getDrivingage() {
		return this.drivingage;
	}

	public void setDrivingage(Integer drivingage) {
		this.drivingage = drivingage;
	}

	public String getLicensecopy() {
		return this.licensecopy;
	}

	public void setLicensecopy(String licensecopy) {
		this.licensecopy = licensecopy;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public Integer getServicetimes() {
		return this.servicetimes;
	}

	public void setServicetimes(Integer servicetimes) {
		this.servicetimes = servicetimes;
	}

	public String getServicegrade() {
		return this.servicegrade;
	}

	public void setServicegrade(String servicegrade) {
		this.servicegrade = servicegrade;
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