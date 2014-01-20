package cn.daijia.dao;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.support.DaoSupport;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

public abstract class BaseDao extends DaoSupport {

	@Resource private SessionFactory sessionFactory;
	@Resource private HibernateTemplate hibernateTemplate;

	protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
		return new HibernateTemplate(sessionFactory);
	}

	public final HibernateTemplate getHibernateTemplate() {
	  return this.hibernateTemplate;
	}

	@Override
	protected final void checkDaoConfig() {
		if (this.hibernateTemplate == null) {
			throw new IllegalArgumentException("'sessionFactory' or 'hibernateTemplate' is required");
		}
	}

	protected final Session getSession()
		throws DataAccessResourceFailureException, IllegalStateException {

		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	protected final DataAccessException convertHibernateAccessException(HibernateException ex) {
		return this.hibernateTemplate.convertHibernateAccessException(ex);
	}

	protected final void releaseSession(Session session) {
		SessionFactoryUtils.releaseSession(session, sessionFactory);
	}

}

