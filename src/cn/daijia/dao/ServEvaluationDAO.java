package cn.daijia.dao;

import cn.daijia.dao.IServEvaluationDAO;
import cn.daijia.vo.InfoCD;
import cn.daijia.vo.ServiceEvaluation;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class ServEvaluationDAO extends HibernateDaoSupport implements IServEvaluationDAO{
	public void saveServEvaluation(String hql){
		Session session=getSession();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.executeUpdate();
		trans.commit();
		session.close();
	}
	public ServiceEvaluation getServEvaluation(int ordernumber){
		Session session=getSession();
		String hql="from ServiceEvaluation s where s.ordernumber=?";
		Query query=session.createQuery(hql);
		query.setParameter(0, ordernumber);
		List lists=query.list();
		ServiceEvaluation serveva=(ServiceEvaluation)lists.get(0);
		session.close();
		return serveva;
	}
	public List getAllEvaluation(){
		Session session=getSession();
		String hql="from ServiceEvaluation";
		Query query=session.createQuery(hql);
		List allevas=query.list();
		session.close();
		return allevas;
	}
	public List searchServEvaluation(String hql){
		Session session=getSession();
		Query query=session.createQuery(hql);
		List servevas=query.list();
		session.close();
		return servevas;
	}

}
