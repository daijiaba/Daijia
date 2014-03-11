package cn.daijia.dao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.daijia.vo.InfoCustomer;

public class TestDao extends HibernateDaoSupport implements ITestDao{
	
	public void saveInfoCustomer(InfoCustomer infoCustomer){
		System.out.println(infoCustomer.getPasswd());
		this.getHibernateTemplate().save(infoCustomer);
	}

}