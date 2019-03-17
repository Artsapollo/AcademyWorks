package introSpring3.service;

import lesson16.entity.Order;

import java.math.BigDecimal;
import java.util.Set;

public interface OrdersService {
    Set<Order> getAllOrders();

    Set<Order> findByQtyBetween(int minQty, int maxQty);

    Order findOrderById(BigDecimal id);

    void insertOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(BigDecimal id);
}
