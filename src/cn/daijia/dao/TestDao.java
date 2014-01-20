package cn.daijia.dao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.daijia.vo.InfoCustomer;

@Repository
public class TestDao extends BaseDao implements ITestDao{
	
	public void saveInfoCustomer(InfoCustomer infoCustomer){
		System.out.println(infoCustomer.getPasswd());
		this.getHibernateTemplate().save(infoCustomer);
	}

}