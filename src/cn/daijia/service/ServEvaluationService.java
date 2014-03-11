package cn.daijia.service;

import java.util.List;

import cn.daijia.dao.IServEvaluationDAO;
import cn.daijia.service.IServEvaluationService;
import cn.daijia.vo.ServiceEvaluation;
public class ServEvaluationService implements IServEvaluationService {
	private IServEvaluationDAO servEvaluationDAO;
	public void saveServEvaluation(String hql){
		servEvaluationDAO.saveServEvaluation(hql);
	}
	public ServiceEvaluation getServEvaluation(int ordernumber){
		return servEvaluationDAO.getServEvaluation(ordernumber);
	}
	public List getAllEvaluation(){
		return servEvaluationDAO.getAllEvaluation();
	}
	public List searchServEvaluation(String hql){
		return servEvaluationDAO.searchServEvaluation(hql);
	}
	public IServEvaluationDAO getServEvaluationDAO() {
		return servEvaluationDAO;
	}
	public void setServEvaluationDAO(IServEvaluationDAO servEvaluationDAO) {
		this.servEvaluationDAO = servEvaluationDAO;
	}
	

}
