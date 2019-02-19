package Lesson16;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

@FixMethodOrder(MethodSorters.JVM)
public class OrderDaoImplIntegrationTest {
    private static final BigDecimal NOT_EXIST_ORDER = BigDecimal.valueOf(-1);
    private static final BigDecimal ALREADY_EXIST_ORDER = BigDecimal.valueOf(112961);
    private static final Order order = new Order(new BigDecimal(111111), null, null,
            null, new BigDecimal(505), new BigDecimal(5005));

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

    @Test
    public void testInsertOrder() throws SQLException{
        assertTrue(orderDao.insertOrder(new Order(new BigDecimal(111111), null, null,
                "AAA", new BigDecimal(906), new BigDecimal(10000))));
    }

    @Test
    public void testUpdateOrder() throws SQLException{
        assertTrue(orderDao.updateOrder(new Order(new BigDecimal(111111), null, null,
                null, new BigDecimal(505), new BigDecimal(5005))));
    }

    @Test
    public void testDeleteOrder() throws SQLException{
        assertTrue(orderDao.deleteOrder(order));
    }

}
