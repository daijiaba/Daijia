package cn.daijia.dao;

import java.util.List;
import cn.daijia.dao.IInfoCDDAO;
import cn.daijia.vo.InfoCD;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class InfoCDDAO extends HibernateDaoSupport implements IInfoCDDAO{
	public void saveInfoCD(InfoCD infoCD){
		this.getHibernateTemplate().save(infoCD);
	}
	public InfoCD searchInfoCD(String hql){
		Session session=getSession();
		InfoCD infoCDs;
		Query query=session.createQuery(hql);
		List lists=query.list();
		if(lists.size()==0){
		    infoCDs=null;
		    return infoCDs;
		}
		infoCDs=(InfoCD)lists.get(lists.size()-1);
		session.close();
		return infoCDs;
	}
	public List getAllInfoCD(){
		Session session = getSession();
		String hql = "select ifc from InfoCD ifc left join ifc.infoOrder ifo";
		Query query=session.createQuery(hql);
		List ifos=query.list();
		session.close();
		return ifos;
		
	}
	public List searchInfoCDByHql(String hql){
		Session session=getSession();
		Query query=session.createQuery(hql);
		List cds=query.list();
		session.close();
		return cds;
	}

}
