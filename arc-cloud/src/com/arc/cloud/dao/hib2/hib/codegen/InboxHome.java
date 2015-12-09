package com.arc.cloud.dao.hib2.hib.codegen;
// Generated 23-Nov-2015 9:50:09 PM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.arc.cloud.dao.util.HibernateUtil;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Inbox.
 * @see com.arc.cloud.dao.hib23.hib.codegen.Inbox
 * @author Hibernate Tools
 */
public class InboxHome {

	private static final Log log = LogFactory.getLog(InboxHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			//return (SessionFactory) new InitialContext().lookup("SessionFactory");
			return HibernateUtil.getSessionFactory();

		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Inbox transientInstance) {
		log.debug("persisting Inbox instance");
		try {
        	Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			
			session.persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Inbox instance) {
		log.debug("attaching dirty Inbox instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Inbox instance) {
		log.debug("attaching clean Inbox instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Inbox persistentInstance) {
		log.debug("deleting Inbox instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Inbox merge(Inbox detachedInstance) {
		log.debug("merging Inbox instance");
		try {
			Inbox result = (Inbox) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Inbox findById(int id) {
		log.debug("getting Inbox instance with id: " + id);
		try {
			Inbox instance = (Inbox) sessionFactory.getCurrentSession().get("com.arc.cloud.dao.hib23.hib.codegen.Inbox",
					id);
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

	public List<Inbox> findByExample(Inbox instance) {
		log.debug("finding Inbox instance by example");
		try {
			List<Inbox> results = (List<Inbox>) sessionFactory.getCurrentSession()
					.createCriteria("com.arc.cloud.dao.hib23.hib.codegen.Inbox").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
