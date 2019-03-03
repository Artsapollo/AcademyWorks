package dbTablesConect;

import lesson22UsingHibernate.OrderModel;
import lesson22UsingHibernate.OrderModelDaoImpl;
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


    public static OrderModel orderInfo(BigDecimal id) {
        LOG.debug("order info");
        OrderModel orderModel;
        try {
            orderModel = entityManager.find(OrderModel.class, id);
            System.out.println(orderModel);
            System.out.println(orderModel.getProducts());
            System.out.println(orderModel.getCustomers());
            System.out.println(orderModel.getSalesreps().getRepOffice());
            System.out.println(orderModel.getSalesreps());
            LOG.debug("successful");
        } catch (RuntimeException e) {
            LOG.error("failed", e);
            throw e;
        }
        return orderModel;
    }


    public static void main(String[] args) {
        TablesInfo.orderInfo(BigDecimal.valueOf(112961));
    }
}