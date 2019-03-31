package introSpring3.repository;

import introSpring3.config.DataConfig;
import lesson16.entity.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.jdbc.datasource.init.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.Assert.*;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
@TestPropertySource("classpath:introSpring3/test.properties") //
public class OrdersRepositoryIntegrationH2Test {

    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private DataSource dataSource;

    //Не работает
    @Before
    public void initDb() {
        Resource initSchema = new ClassPathResource("introSpring3\\script\\schema.sql");
        Resource data = new ClassPathResource("introSpring3\\script\\data.sql");
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, data);
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);
    }

    @Test
    public void testGetAllOrders(){
        List<Order> order = ordersRepository.findAll();
        System.out.println(order); //В нормальных тестах system out писать нельзя
        assertTrue(order.size() >= 2);
    }
}