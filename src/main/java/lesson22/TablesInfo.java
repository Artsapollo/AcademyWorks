package lesson22;

import dbTables.*;
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


    public static Orders orderInfo(BigDecimal id) {
        LOG.debug("order info");
        Orders orders;
        try {
            orders = entityManager.find(Orders.class, id);
            System.out.println(orders);
            System.out.println(orders.getProduct());
            System.out.println(orders.getCustomers());
            System.out.println(orders.getSalesreps().getRepOffice());
            System.out.println(orders.getSalesreps());
            LOG.debug("successful");
        } catch (RuntimeException e) {
            LOG.error("failed", e);
            throw e;
        }
        return orders;
    }

    public static void main(String[] args) {
        TablesInfo.orderInfo(BigDecimal.valueOf(112961));
    }
}