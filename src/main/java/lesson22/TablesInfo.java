package lesson22;

import dbTables.Customers;
import dbTables.Offices;
import dbTables.Products;
import dbTables.Salesreps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Locale;

public class TablesInfo {
    private static EntityManagerFactory factory;

    static {
        Locale.setDefault(Locale.ENGLISH);
        factory = Persistence.createEntityManagerFactory("PERSISTENCE");
    }

    private static final Logger LOG = LogManager.getLogger(OrderModelDaoImpl.class);
    private static EntityManager entityManager = factory.createEntityManager();


    public static void productInfo(String productId) {
        LOG.debug("product info");
        try {
            System.out.println(entityManager.find(Products.class, productId));
            LOG.debug("successful");
        } catch (RuntimeException e) {
            LOG.error("failed", e);
            throw e;
        }
    }

    public static void orderInfo(BigDecimal orderNum) {
        LOG.debug("order info");
        try {
            System.out.println(entityManager.find(OrderModel.class, orderNum));
            LOG.debug("successful");
        } catch (RuntimeException e) {
            LOG.error("failed", e);
            throw e;
        }
    }

    public static void customerInfo(BigDecimal custNum) {
        LOG.debug("customer info");
        try {
            System.out.println(entityManager.find(Customers.class, custNum));
            LOG.debug("successful");
        } catch (RuntimeException e) {
            LOG.error("failed", e);
            throw e;
        }
    }

    public static void officeInfo(BigDecimal office) {
        LOG.debug("office info");
        try {
            System.out.println(entityManager.find(Offices.class, office));
            LOG.debug("successful");
        } catch (RuntimeException e) {
            LOG.error("failed", e);
            throw e;
        }
    }

    public static void salesrepsInfo(BigDecimal emplNum) {
        LOG.debug("salesreps info");
        try {
            System.out.println(entityManager.find(Salesreps.class, emplNum));
            LOG.debug("successful");
        } catch (RuntimeException e) {
            LOG.error("failed", e);
            throw e;
        }
    }

    public static void main(String[] args) {
        TablesInfo.productInfo("41033");
        TablesInfo.orderInfo(BigDecimal.valueOf(112961));
        TablesInfo.customerInfo(BigDecimal.valueOf(2102));
        TablesInfo.officeInfo(BigDecimal.valueOf(11));
        TablesInfo.salesrepsInfo(BigDecimal.valueOf(103));
    }
}