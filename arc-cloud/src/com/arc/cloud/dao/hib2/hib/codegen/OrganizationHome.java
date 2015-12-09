package com.arc.cloud.dao.hib2.hib.codegen;
// Generated 4-Dec-2015 8:37:11 PM by Hibernate Tools 4.3.1.Final

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
 * Home object for domain model class Organization.
 * @see com.arc.cloud.dao.hib23.hib.codegen.Organization
 * @author Hibernate Tools
 */
public class OrganizationHome {

	private static final Log log = LogFactory.getLog(OrganizationHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Organization transientInstance) {
		log.debug("persisting Organization instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			sessionFactory.getCurrentSession().persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Organization instance) {
		log.debug("attaching dirty Organization instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Organization instance) {
		log.debug("attaching clean Organization instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(long id) {
		log.debug("deleting Organization instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			Organization persistentInstance = (Organization) session.get("com.arc.cloud.dao.hib2.hib.codegen.Organization", id);
			session.delete(persistentInstance);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public void merge(Organization detachedInstance) {
		log.debug("merging Organization instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.update(detachedInstance);
			tx.commit();
			log.debug("merge successful");
		
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Organization findById(long id) {
		log.debug("getting Organization instance with id: " + id);
		try {
			Organization instance = (Organization) sessionFactory.getCurrentSession()
					.get("com.arc.cloud.dao.hib2.hib.codegen.Organization", id);
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

	public List<Organization> findByExample(Organization instance) {
		log.debug("finding Organization instance by example");
		try {
			List<Organization> results = (List<Organization>) sessionFactory.getCurrentSession()
					.createCriteria("com.arc.cloud.dao.hib2.hib.codegen.Organization").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
