package cn.daijia.dao;

import java.util.List;

import cn.daijia.vo.InfoAccount;
import cn.daijia.dao.IInfoAccountDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class InfoAccountDAO extends HibernateDaoSupport implements IInfoAccountDAO{
	public void saveAccount(InfoAccount infoAccount){
		this.getHibernateTemplate().save(infoAccount);
	}
	public InfoAccount getAccount(Integer usernumber){
		Session session = getSession();
		String hql="from InfoAccount ifa where ifa.usernumber=?";
		Query query=session.createQuery(hql);
		query.setParameter(0, usernumber);
		List infoAccount=query.list();
		if(infoAccount.size()!=0){
		   InfoAccount ifa=(InfoAccount)infoAccount.get(0);
		   return ifa;
		}
		session.close();
		return null;
	}
	public void updateAccount(String hql){
		Session session=getSession();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.executeUpdate();
		trans.commit();
		session.close();
	}
	public InfoAccount getAccountByQuestion(String hql){
		Session session = getSession();
		Query query=session.createQuery(hql);
		List infoa=query.list();
		if(infoa.size()!=0){
		   InfoAccount ifa=(InfoAccount)infoa.get(0);
		   return ifa;
		}
		session.close();
		return null;
	}

}
