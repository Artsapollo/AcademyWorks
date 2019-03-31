package introSpring3.repository;

import introSpring3.config.DataConfig;
import lesson16.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
@Transactional //возволяет ставить условия для роллбэка
@Rollback
public class OrdersRepositoryIntegrationTest {
//    private static final BigDecimal NOT_EXIST_ORDER = BigDecimal.valueOf(-1);
//    private static final BigDecimal ALREADY_EXIST_ORDER = BigDecimal.valueOf(112979);
//    private static final Order ORDER = new Order(BigDecimal.valueOf(12345), null, null, null, new Date(), null,
//            BigDecimal.valueOf(-1), null);

    /*
    ДЗ
    Сделать тесты для всех методов в разных вариациях. Например: Когда можно достать объект, когда нельзя
     */

    @Autowired
    private OrdersRepository ordersRepository;

    @Test
    public void testGetAllOrders(){
        List<Order> order = ordersRepository.findAll();
        System.out.println(order); //В нормальных тестах system out писать нельзя
        assertTrue(order.size() > 15);
    }
}