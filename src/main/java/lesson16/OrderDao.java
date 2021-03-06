package lesson16;

import lesson16.entity.Order;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

public interface OrderDao {
    Set<Order> getAllOrders() throws SQLException;

    Set<Order> getAllOrdersWithJoin() throws SQLException;

    Order findOrderById(BigDecimal id) throws SQLException;

    boolean insertOrder(Order order) throws SQLException;

    boolean updateOrder(Order order) throws SQLException;

    boolean deleteOrder(Order order) throws SQLException;
}
