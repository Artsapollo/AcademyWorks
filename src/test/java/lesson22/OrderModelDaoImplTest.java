package lesson22;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.SQLException;

import static junit.framework.TestCase.assertTrue;

@FixMethodOrder(MethodSorters.JVM)
public class OrderModelDaoImplTest {
    private static final OrderModel orderModel = new OrderModel(new BigDecimal(111111), null, null,
            null, new BigDecimal(505), new BigDecimal(5005));

    private OrderModelDao orderModelDao = new OrderModelDaoImpl();

    @Test
    public void insertOrder() throws SQLException {
        assertTrue(orderModelDao.insertOrderModel(orderModel));
    }

    @Test
    public void testUpdateOrder() throws SQLException{
        assertTrue(orderModelDao.updateOrderModel(new OrderModel(new BigDecimal(111111), null, null,
                null, new BigDecimal(101), new BigDecimal(1001))));
    }

    @Test
    public void testDeleteOrder() throws SQLException{
        assertTrue(orderModelDao.deleteOrderModel(new BigDecimal(111111)));
    }
}