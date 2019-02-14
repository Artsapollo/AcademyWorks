package Lesson16;

import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class OrderDaoImplIntegrationTest {
    private static final BigDecimal NOT_EXIST_ORDER = BigDecimal.valueOf(-1);
    private static final BigDecimal ALREADY_EXIST_ORDER = BigDecimal.valueOf(112961);
    private static final Order ORDER = new Order(BigDecimal.valueOf(12345), null, new Date(), null, BigDecimal.valueOf(-1), null);

    public OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void testGetAllOrdersWithJoin() throws SQLException{
        Set<Order> orders = orderDao.getAllOrdersWithJoin();
        System.out.println(orders);
        assertFalse(orders.isEmpty());
    }

    @Test
    public void testGetAllOrders() throws SQLException {
        Set<Order> orders = orderDao.getAllOrders();
        System.out.println(orders);
        assertTrue(orders.size() > 15);
    }


    @Test
    public void testFindOrderById() throws SQLException {
        Order order = orderDao.findOrderById(ALREADY_EXIST_ORDER);
        System.out.println(order);
        assertNotNull(order);
    }

    @Test
    public void testFindOrderByIdNotFound() throws SQLException {
        Order order = orderDao.findOrderById(NOT_EXIST_ORDER);
        System.out.println(order);
        assertNull(order);
    }

}