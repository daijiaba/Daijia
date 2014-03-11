package cn.daijia.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.daijia.service.IServEvaluationService;
import cn.daijia.vo.ServiceEvaluation;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ServEvaluationAction extends ActionSupport{
	public ServiceEvaluation servEvaluation;
	public static IServEvaluationService servEvaluationService;
	public Integer ordernumber;
	public Short status;
	public String score;
	public String information;
	public String evaluationtime;
	
	public String saveServEva(){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		evaluationtime=sdf.format(date);
		StringBuffer hql=new StringBuffer("update ServiceEvaluation s set ");
		if(information!=null||score!=null)
			status=1;
		else
			status=0;
		hql.append("s.status="+status);
		if(score!=null&&score.length()!=0)
			hql.append(", s.score="+score);
		if(information!=null&&information.length()!=0)
			hql.append(", s.information='"+information+"'");
		hql.append(", s.evaluationtime='"+evaluationtime+"'");
		hql.append(" where s.ordernumber="+ordernumber);
		servEvaluationService.saveServEvaluation(hql.toString());
		return SUCCESS;
	}
	
	public String getServEva(){
		ServiceEvaluation serveva=servEvaluationService.getServEvaluation(ordernumber);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("serveva", serveva);
		return SUCCESS;
	}
	
	public String getAllEvas(){
		List allevas=servEvaluationService.getAllEvaluation();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("allevas", allevas);
		return SUCCESS;
	}
	
	public String searchServEva(){
		StringBuffer hql=new StringBuffer("from ServiceEvaluation s where 1=1 ");
		if(ordernumber!=null&&ordernumber.SIZE!=0)
			hql.append(" and ordernumber="+ordernumber);
		if(status!=null&&status.SIZE!=0)
			hql.append(" and status="+status);
		List servevas=servEvaluationService.searchServEvaluation(hql.toString());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("servevas", servevas);
		return SUCCESS;
	}
	
	public void autoSaveServEva(String hql){
		servEvaluationService.saveServEvaluation(hql);
	}
	
	public List searchServEvaByStatu(){
		String hql="from ServiceEvaluation s where s.status=0 ";
		List evas=servEvaluationService.searchServEvaluation(hql);
		return evas;
	}
	

	public ServiceEvaluation getServEvaluation() {
		return servEvaluation;
	}

	public void setServEvaluation(ServiceEvaluation servEvaluation) {
		this.servEvaluation = servEvaluation;
	}

	public IServEvaluationService getServEvaluationService() {
		return servEvaluationService;
	}

	public void setServEvaluationService(
			IServEvaluationService servEvaluationService) {
		this.servEvaluationService = servEvaluationService;
	}

	public Integer getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(Integer ordernumber) {
		this.ordernumber = ordernumber;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}
	

}
