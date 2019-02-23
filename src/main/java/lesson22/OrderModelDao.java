package lesson22;

import javax.persistence.criteria.Order;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

public interface OrderModelDao {

    Set<OrderModel> getAllOrders() throws SQLException;

    Order findOrderModelById(BigDecimal id) throws SQLException;

    boolean insertOrderModel (OrderModel orderModel) throws SQLException;

    boolean updateOrderModel (OrderModel orderModel) throws SQLException;

    boolean deleteOrderModel (BigDecimal id) throws SQLException;
}
