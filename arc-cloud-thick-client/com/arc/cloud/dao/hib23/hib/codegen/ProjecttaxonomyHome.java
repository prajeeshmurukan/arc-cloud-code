package com.arc.cloud.dao.hib23.hib.codegen;
// Generated 4-Dec-2015 8:37:11 PM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Projecttaxonomy.
 * @see com.arc.cloud.dao.hib23.hib.codegen.Projecttaxonomy
 * @author Hibernate Tools
 */
public class ProjecttaxonomyHome {

	private static final Log log = LogFactory.getLog(ProjecttaxonomyHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Projecttaxonomy transientInstance) {
		log.debug("persisting Projecttaxonomy instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Projecttaxonomy instance) {
		log.debug("attaching dirty Projecttaxonomy instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
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
					.get("com.arc.cloud.dao.hib23.hib.codegen.Projecttaxonomy", id);
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

	public List<Projecttaxonomy> findByExample(Projecttaxonomy instance) {
		log.debug("finding Projecttaxonomy instance by example");
		try {
			List<Projecttaxonomy> results = (List<Projecttaxonomy>) sessionFactory.getCurrentSession()
					.createCriteria("com.arc.cloud.dao.hib23.hib.codegen.Projecttaxonomy").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
