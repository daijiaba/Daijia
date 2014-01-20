package cn.daijia.vo;

/**
 * InfoWebsite entity. @author MyEclipse Persistence Tools
 */

public class InfoWebsite implements java.io.Serializable {

	// Fields

	private Integer newsnumber;
	private String titile;
	private String content;
	private String class_;
	private String publishtime;
	private Short status;

	// Constructors

	/** default constructor */
	public InfoWebsite() {
	}

	/** minimal constructor */
	public InfoWebsite(String titile) {
		this.titile = titile;
	}

	/** full constructor */
	public InfoWebsite(String titile, String content, String class_,
			String publishtime, Short status) {
		this.titile = titile;
		this.content = content;
		this.class_ = class_;
		this.publishtime = publishtime;
		this.status = status;
	}

	// Property accessors

	public Integer getNewsnumber() {
		return this.newsnumber;
	}

	public void setNewsnumber(Integer newsnumber) {
		this.newsnumber = newsnumber;
	}

	public String getTitile() {
		return this.titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getPublishtime() {
		return this.publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

}