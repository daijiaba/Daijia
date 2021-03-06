package cn.daijia.vo;

/**
 * ServiceEvaluation entity. @author MyEclipse Persistence Tools
 */

public class ServiceEvaluation implements java.io.Serializable {

	// Fields

	private Integer ordernumber;
	private Short status;
	private String score;
	private String information;
	private String evaluationtime;

	// Constructors

	/** default constructor */
	public ServiceEvaluation() {
	}

	/** minimal constructor */
	public ServiceEvaluation(Short status) {
		this.status = status;
	}

	/** full constructor */
	public ServiceEvaluation(Short status, String score, String information,
			String evaluationtime) {
		this.status = status;
		this.score = score;
		this.information = information;
		this.evaluationtime = evaluationtime;
	}

	// Property accessors

	public Integer getOrdernumber() {
		return this.ordernumber;
	}

	public void setOrdernumber(Integer ordernumber) {
		this.ordernumber = ordernumber;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getInformation() {
		return this.information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getEvaluationtime() {
		return this.evaluationtime;
	}

	public void setEvaluationtime(String evaluationtime) {
		this.evaluationtime = evaluationtime;
	}

}