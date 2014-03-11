package cn.daijia.dao;

import cn.daijia.vo.ServiceEvaluation;
import java.util.List;
public interface IServEvaluationDAO {
	public void saveServEvaluation(String hql);
	public ServiceEvaluation getServEvaluation(int ordernumber);
	public List getAllEvaluation();
	public List searchServEvaluation(String hql);

}
