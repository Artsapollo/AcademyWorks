package lesson22UsingHibernate;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@FixMethodOrder(MethodSorters.JVM)
public class OrderModelDaoImplTest {
    private static final OrderModel orderModel = new OrderModel(new BigDecimal(111111), null, null,
            null, new BigDecimal(505), new BigDecimal(5005));

    private OrderModelDao orderModelDao = new OrderModelDaoImpl();

    @Test
    public void getAllOrders() {
        assertNotNull(orderModelDao.getAllOrders());
    }

    @Test
    public void findOrderById() {
        OrderModel tutu = orderModelDao.findOrderModelById(new BigDecimal(112961));
        assertNotNull(tutu);
    }

    @Test
    public void insertOrderModel(){
        assertTrue(orderModelDao.
                insertOrderModel(orderModel));
    }

    @Test
    public void updateOrderModel(){
        assertTrue(orderModelDao.updateOrderModel(new OrderModel(new BigDecimal(111111),null,
                null,null,new BigDecimal(101),new BigDecimal(1001))));
    }

    @Test
    public void deleteOrderModel(){
        assertTrue(orderModelDao.
                deleteOrderModel(new BigDecimal(111111)));
    }


}