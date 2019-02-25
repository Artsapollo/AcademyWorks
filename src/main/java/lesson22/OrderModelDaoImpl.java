package lesson22;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.Order;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Set;

public class OrderModelDaoImpl implements OrderModelDao {

    private static EntityManagerFactory factory;

    static {
        Locale.setDefault(Locale.ENGLISH);
        factory = Persistence.createEntityManagerFactory("PERSISTENCE");
    }

    private static final Logger LOG = LogManager.getLogger(OrderModelDaoImpl.class);
    private EntityManager entityManager = factory.createEntityManager();

    @Override
    public Set<OrderModel> getAllOrders() throws SQLException {
        return null;
    }

    @Override
    public Order findOrderModelById (BigDecimal id) throws SQLException {
        return null;
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
}
