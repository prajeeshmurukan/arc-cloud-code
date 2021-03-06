package com.arc.cloud.dao.hib2.hib.codegen;
// Generated 23-Nov-2015 8:58:27 AM by Hibernate Tools 4.3.1.Final

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
 * Home object for domain model class Archiveaudit.
 * @see com.arc.cloud.dao.hib23.hib.codegen.Archiveaudit
 * @author Hibernate Tools
 */
public class ArchiveauditHome {

	private static final Log log = LogFactory.getLog(ArchiveauditHome.class);

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

	public void persist(Archiveaudit transientInstance) {
		log.debug("persisting Archiveaudit instance");
		try {
			
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Archiveaudit instance) {
		log.debug("attaching dirty Archiveaudit instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Archiveaudit instance) {
		log.debug("attaching clean Archiveaudit instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Archiveaudit persistentInstance) {
		log.debug("deleting Archiveaudit instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Archiveaudit merge(Archiveaudit detachedInstance) {
		log.debug("merging Archiveaudit instance");
		try {
			Archiveaudit result = (Archiveaudit) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Archiveaudit findById(int id) {
		log.debug("getting Archiveaudit instance with id: " + id);
		try {
			Archiveaudit instance = (Archiveaudit) sessionFactory.getCurrentSession()
					.get("com.arc.cloud.dao.hib23.hib.codegen.Archiveaudit", id);
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

	public List<Archiveaudit> findByExample(Archiveaudit instance) {
		log.debug("finding Archiveaudit instance by example");
		try {
			List<Archiveaudit> results = (List<Archiveaudit>) sessionFactory.getCurrentSession()
					.createCriteria("com.arc.cloud.dao.hib23.hib.codegen.Archiveaudit").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
