package cn.daijia.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao extends BaseDao implements IOrderDao{
	public List getDriverStatus(){
		Session session = getSession();
		String hql = "from StatusDriver sd";
		Query query = session.createQuery(hql);
		List users = query.list();
		session.close();
		return users;
	}
}
