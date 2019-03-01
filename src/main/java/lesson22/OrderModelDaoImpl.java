package lesson22;


import dbTables.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.File;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class OrderModelDaoImpl implements OrderModelDao {

    static Session sessionObj;
    static SessionFactory sessionFactoryObj;

    private static final Logger LOG = LogManager.getLogger(OrderModelDaoImpl.class);

    // This Method Is Used To Create The Hibernate's SessionFactory Object
    private static SessionFactory buildSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);

        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.addAnnotatedClass(OrderModel.class);
        configObj.addAnnotatedClass(Customers.class);
        configObj.addAnnotatedClass(Offices.class);
        configObj.addAnnotatedClass(Products.class);
        configObj.addAnnotatedClass(Salesreps.class);
        configObj.configure(new File("src\\main\\resources\\lesson24\\hibernate.cfg.xml"));

        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
                .applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }

    @Override
    public Set<OrderModel> getAllOrders() {
        return null;
    }

    @Override
    public OrderModel findOrderModelById(BigDecimal id) {
        OrderModel orderModel = null;
        try{
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            orderModel = sessionObj.load(OrderModel.class, id);
        } catch (Exception sqlException){
//            if(null != sessionObj.getTransaction()){
//                LOG.info("\n.................Transaction is being rolled back.............");
//                sessionObj.getTransaction().rollback();
//            }
            sqlException.printStackTrace();
        }
        return orderModel;
    }

    @Override
    public boolean insertOrderModel(OrderModel orderModel) {
        return false;
    }

    @Override
    public boolean updateOrderModel(OrderModel orderModel) {
        return false;
    }

    @Override
    public boolean deleteOrderModel(BigDecimal id) {
        return false;
    }

    /*
    Eclipse

    @Override
    public Set<OrderModel> getAllOrders() {
        LOG.debug("getting all orders");
        try{
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery <OrderModel> cq = cb.createQuery(OrderModel.class);
            Root<OrderModel> rootEnrty = cq.from(OrderModel.class);
            CriteriaQuery<OrderModel> all = cq.select(rootEnrty);
            TypedQuery<OrderModel> allQuery = entityManager.createQuery(all);
            return new HashSet<>(allQuery.getResultList());
        } catch (RuntimeException re){
            LOG.error("getAll Failed", re);
            throw re;
        }
    }

    @Override
    public OrderModel findOrderModelById (BigDecimal id) {
        LOG.debug("find order by id: " + id);
        try{
            OrderModel instance = entityManager.find(OrderModel.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException e){
            LOG.error("get failed", e);
            throw e;
        }

    }

    @Override
    public boolean insertOrderModel (OrderModel orderModel) {
        LOG.debug("persisting Orders instance");
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(orderModel);
            entityManager.getTransaction().commit();
            LOG.debug("persist succesful");
            return true;
        } catch (RuntimeException exception) {
            if (entityManager != null) {
                System.out.println("Transaction is begin rolled back.");
                entityManager.getTransaction().rollback();
            }
            LOG.error("persist failed", exception);
            throw exception;
        }
    }

    @Override
    public boolean updateOrderModel (OrderModel orderModel) {
        LOG.debug("merging Orders instance");
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(orderModel);
            entityManager.getTransaction().commit();
            LOG.debug("merge successful");
            return true;
        } catch (RuntimeException re) {
            if (entityManager != null) {
                System.out.println("Transaction is being rolled back.");
                entityManager.getTransaction().rollback();
            }
            LOG.error("merge failed", re);
            throw re;
        }
    }

    @Override
    public boolean deleteOrderModel (BigDecimal id) {
        LOG.debug("removing Orders instance");
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(OrderModel.class, id));
            entityManager.getTransaction().commit();
            LOG.debug("remove successful");
            return true;
        } catch (RuntimeException re) {
            if (entityManager != null) {
                System.out.println("Transaction is being rolled back.");
                entityManager.getTransaction().rollback();
            }
            LOG.error("remove failed", re);
            throw re;
        }
    }
    */
}
