package com.arc.cloud.dao.hib2.hib.codegen;
// Generated 11-Nov-2015 9:40:26 AM by Hibernate Tools 4.3.1.Final

import java.util.List;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.arc.cloud.dao.util.HibernateUtil;

/**
 * Home object for domain model class Projecttaxonomy.
 * @see com.arc.cloud.dao.hib2.hib.codegen.Projecttaxonomy
 * @author Hibernate Tools
 */
public class ProjecttaxonomyHome {

	private static final Log log = LogFactory.getLog(ProjecttaxonomyHome.class);

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

	public void persist(Projecttaxonomy transientInstance) {
		log.debug("persisting Projecttaxonomy instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.save(transientInstance);

			tx.commit();
			
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Projecttaxonomy instance) {
		log.debug("attaching dirty Projecttaxonomy instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(instance);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Projecttaxonomy instance) {
		log.debug("attaching clean Projecttaxonomy instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Projecttaxonomy persistentInstance) {
		log.debug("deleting Projecttaxonomy instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Projecttaxonomy merge(Projecttaxonomy detachedInstance) {
		log.debug("merging Projecttaxonomy instance");
		try {
			Projecttaxonomy result = (Projecttaxonomy) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Projecttaxonomy findById(int id) {
		log.debug("getting Projecttaxonomy instance with id: " + id);
		try {
			Projecttaxonomy instance = (Projecttaxonomy) sessionFactory.getCurrentSession()
					.get("com.arc.cloud.dao.hib2.hib.codegen.Projecttaxonomy", id);
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

	public List findByExample(Projecttaxonomy instance) {
		log.debug("finding Projecttaxonomy instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.arc.cloud.dao.hib2.hib.codegen.Projecttaxonomy").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
