package lesson22;

import java.math.BigDecimal;
import java.util.Set;

public interface OrderModelDao {

    Set<OrderModel> getAllOrders();

    OrderModel findOrderModelById(BigDecimal id);

    boolean insertOrderModel (OrderModel orderModel);

    boolean updateOrderModel (OrderModel orderModel);

    boolean deleteOrderModel (BigDecimal id);
}
