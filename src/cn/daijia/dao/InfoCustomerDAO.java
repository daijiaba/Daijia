package cn.daijia.dao;

import java.util.List;
import cn.daijia.dao.IInfoCustomerDAO;
import cn.daijia.vo.InfoCustomer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class InfoCustomerDAO extends HibernateDaoSupport implements IInfoCustomerDAO{
	public InfoCustomer validateInfoCustomer(String username,String password){
		Session session=getSession();
		String hql="from InfoCustomer ifc where ifc.username=? and ifc.passwd=?";
		Query query=session.createQuery(hql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List infoCustomers=query.list();
		if(infoCustomers.size()!=0){
			InfoCustomer infoCustomer=(InfoCustomer)infoCustomers.get(0);
			return infoCustomer;
		}
		session.close();
		return null;
	}
	public InfoCustomer getUserByUsertel(String usertel){
		Session session=getSession();
		String hql="from InfoCustomer ifc where ifc.usertel=?";
		Query query=session.createQuery(hql);
		query.setParameter(0, usertel);
		List customers=query.list();
		if(customers.size()!=0){
			InfoCustomer customer=(InfoCustomer)customers.get(0);
			return customer;
		}
		session.close();
		return null;
	}
	public InfoCustomer getUserByEmail(String hql){
		Session session=getSession();
		Query query=session.createQuery(hql);
		List cus=query.list();
		if(cus.size()!=0){
			InfoCustomer custom=(InfoCustomer)cus.get(0);
			return custom;
		}
		session.close();
		return null;
	}

}
