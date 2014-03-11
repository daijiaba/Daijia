package cn.daijia.service;

import java.util.List;
import cn.daijia.vo.ServiceEvaluation;;
public interface IServEvaluationService {
	public void saveServEvaluation(String hql);
	public ServiceEvaluation getServEvaluation(int ordernumber);
	public List getAllEvaluation();
	public List searchServEvaluation(String hql);

}
