package com.arc.cloud.dao.hib2.hib.codegen;
// Generated 23-Nov-2015 8:39:18 AM by Hibernate Tools 4.3.1.Final


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Custpurl.
 * @see com.arc.cloud.dao.hib2.hib.codegen.Custpurl
 * @author Hibernate Tools
 */
public class CustpurlHome {

    private static final Log log = LogFactory.getLog(CustpurlHome.class);

    private final SessionFactory sessionFactory = getSessionFactory();
    
    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        }
        catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }
    
    public void persist(Custpurl transientInstance) {
        log.debug("persisting Custpurl instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(Custpurl instance) {
        log.debug("attaching dirty Custpurl instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Custpurl instance) {
        log.debug("attaching clean Custpurl instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Custpurl persistentInstance) {
        log.debug("deleting Custpurl instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Custpurl merge(Custpurl detachedInstance) {
        log.debug("merging Custpurl instance");
        try {
            Custpurl result = (Custpurl) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Custpurl findById( int id) {
        log.debug("getting Custpurl instance with id: " + id);
        try {
            Custpurl instance = (Custpurl) sessionFactory.getCurrentSession()
                    .get("com.arc.cloud.dao.hib2.hib.codegen.Custpurl", id);
            if (instance==null) {
                log.debug("get successful, no instance found");
            }
            else {
                log.debug("get successful, instance found");
            }
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public List<Custpurl> findByExample(Custpurl instance) {
        log.debug("finding Custpurl instance by example");
        try {
            List<Custpurl> results = (List<Custpurl>) sessionFactory.getCurrentSession()
                    .createCriteria("com.arc.cloud.dao.hib2.hib.codegen.Custpurl")
                    .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    } 
}

