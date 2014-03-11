package cn.daijia.dao;

import java.util.List;
import cn.daijia.dao.IInfoOrderDAO;
import cn.daijia.vo.InfoCustomer;
import cn.daijia.vo.InfoOrder;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class InfoOrderDAO extends HibernateDaoSupport implements IInfoOrderDAO{
	public List searchInfoOrder(String hql){
		Session session=getSession();
		Query query=session.createQuery(hql);
		List infoOrders=query.list();
		session.close();
		return infoOrders;
	}
	public List getAllIfoOrder(){
		Session session=getSession();
		Query query=session.createQuery("select ifo from InfoOrder ifo left join ifo.infoOrderPay ifop");
		List allOrders=query.list();
		session.close();
		return allOrders;
	}
	public InfoOrder getOrderByOrdernumber(Integer ordernumber){
		Session session=getSession();
		String hql="from InfoOrder ifo where ifo.ordernumber=?";
		Query query=session.createQuery(hql);
		query.setParameter(0, ordernumber);
		List infoOrders=query.list();
		InfoOrder infoOrder=(InfoOrder)infoOrders.get(0);
		session.close();
		return infoOrder;
	}

}
