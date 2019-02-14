package Lesson16;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

public interface OrderDao {

    Order findOrderById(BigDecimal id) throws SQLException;

    boolean insertOrder(Order order) throws SQLException;

    boolean updateOrder(Order order) throws SQLException;

    boolean deleteOrder(BigDecimal id) throws SQLException;
}
