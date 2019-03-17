package introSpring3;

import introSpring3.repository.OrdersRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class MainSpringData {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("introSpring3.config");

        OrdersRepository ordersRepository = context.getBean(OrdersRepository.class);
//        ordersRepository.findAll().forEach(System.out::println);

        ordersRepository.findByQtyBetween(BigDecimal.valueOf(5), BigDecimal.valueOf(15)).forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");
        ordersRepository.findByQtyBetween(BigDecimal.valueOf(5), BigDecimal.valueOf(15)).forEach(System.out::println);
//        ordersRepository.findByCustomer_CompanyLike("Po%").forEach(System.out::println);



        context.close();
    }
}
