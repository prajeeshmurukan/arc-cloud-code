package com.arc.cloud.dao.hib.codegen;
// Generated 10-Nov-2015 7:33:20 PM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class CustHist.
 * @see com.arc.cloud.dao.hib.codegen.CustHist
 * @author Hibernate Tools
 */
public class CustHistHome {

	private static final Log log = LogFactory.getLog(CustHistHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(CustHist transientInstance) {
		log.debug("persisting CustHist instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CustHist instance) {
		log.debug("attaching dirty CustHist instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CustHist instance) {
		log.debug("attaching clean CustHist instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CustHist persistentInstance) {
		log.debug("deleting CustHist instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CustHist merge(CustHist detachedInstance) {
		log.debug("merging CustHist instance");
		try {
			CustHist result = (CustHist) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CustHist findById(int id) {
		log.debug("getting CustHist instance with id: " + id);
		try {
			CustHist instance = (CustHist) sessionFactory.getCurrentSession()
					.get("com.arc.cloud.dao.hib.codegen.CustHist", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CustHist instance) {
		log.debug("finding CustHist instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.arc.cloud.dao.hib.codegen.CustHist")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
