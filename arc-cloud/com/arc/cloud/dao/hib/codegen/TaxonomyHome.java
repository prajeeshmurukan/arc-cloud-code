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
 * Home object for domain model class Taxonomy.
 * @see com.arc.cloud.dao.hib.codegen.Taxonomy
 * @author Hibernate Tools
 */
public class TaxonomyHome {

	private static final Log log = LogFactory.getLog(TaxonomyHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Taxonomy transientInstance) {
		log.debug("persisting Taxonomy instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Taxonomy instance) {
		log.debug("attaching dirty Taxonomy instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Taxonomy instance) {
		log.debug("attaching clean Taxonomy instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Taxonomy persistentInstance) {
		log.debug("deleting Taxonomy instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Taxonomy merge(Taxonomy detachedInstance) {
		log.debug("merging Taxonomy instance");
		try {
			Taxonomy result = (Taxonomy) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Taxonomy findById(int id) {
		log.debug("getting Taxonomy instance with id: " + id);
		try {
			Taxonomy instance = (Taxonomy) sessionFactory.getCurrentSession()
					.get("com.arc.cloud.dao.hib.codegen.Taxonomy", id);
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

	public List findByExample(Taxonomy instance) {
		log.debug("finding Taxonomy instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.arc.cloud.dao.hib.codegen.Taxonomy")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
