package introSpring3.controller;

import introSpring3.service.OrdersService;
import lesson16.entity.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger LOG = LogManager.getLogger(OrderController.class);

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/{id}")
    public @ResponseBody Order getOrderById(@PathVariable("id") int id){
        LOG.info("getOrderById start, id={}", id);
        Order result = ordersService.findOrderById(BigDecimal.valueOf(id));
        LOG.info("getOrderById end");
        return result;
    }
}
