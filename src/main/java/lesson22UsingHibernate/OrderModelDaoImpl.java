package lesson22UsingHibernate;


import dbTables.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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
        Set<OrderModel> orderModel = new HashSet<>();
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            orderModel = new HashSet<>(sessionObj.createQuery("FROM OrderModel").list());
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n...Transaction failed...");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return orderModel;
    }

    @Override
    public OrderModel findOrderModelById(BigDecimal id) {
        OrderModel orderModel = null;
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            orderModel = sessionObj.load(OrderModel.class, id);
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n...Transaction failed...");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }
        return orderModel;
    }

    @Override
    public boolean insertOrderModel(OrderModel orderModel) {
        boolean result = false;
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            sessionObj.save(orderModel);
            sessionObj.getTransaction().commit();
            result = true;
            LOG.info("\n.......Success.....");
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n...Transaction failed...");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return result;
    }

    @Override
    public boolean updateOrderModel(OrderModel orderModel) {
        boolean result = false;
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            OrderModel om = sessionObj.get(OrderModel.class, orderModel.getOrderNum());
            om.setAmount(om.getAmount());
            om.setQty(om.getQty());

            sessionObj.getTransaction().commit();
            result = true;
            LOG.info("\n....Success....");
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n...Transaction failed...");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return result;
    }

    @Override
    public boolean deleteOrderModel(BigDecimal id) {
        boolean result = false;

        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            sessionObj.delete(sessionObj.get(OrderModel.class, id));

            sessionObj.getTransaction().commit();
            result = true;
            LOG.info("\n....Success....");
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n.......Transaction failed.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return result;
    }
}
