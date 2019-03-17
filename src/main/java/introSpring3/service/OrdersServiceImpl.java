package introSpring3.service;

import introSpring3.exception.DeleteException;
import introSpring3.repository.OrdersRepository;
import lesson16.entity.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class OrdersServiceImpl implements OrdersService {
    private static final Logger LOG = LogManager.getLogger(OrdersServiceImpl.class);

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Set<Order> getAllOrders() {
        LOG.debug("getAllOrders");
        HashSet<Order> result = new HashSet<>(ordersRepository.findAll());
        LOG.debug("getAllOrders return {} records", result.size());
        return result;
    }

    @Override
    public Set<Order> findByQtyBetween(int minQty, int maxQty) {
        return null;
    }

    @Override
    public Order findOrderById(BigDecimal id) {
        return null;
    }

    @Override
    public void insertOrder(Order order) {

    }

    @Override
    public void updateOrder(Order order) {

    }

    @Override
    public void deleteOrder(BigDecimal id) {
        LOG.debug("deleteOrder, id={}", id);
        try {
            ordersRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            LOG.warn("Cannot deleteOrder with id{}, because doesn't exist", id);
            throw new DeleteException("Cannot delete Order by Id=" + id + ", because it doesn't exist");
        }
        LOG.debug("deleteOrder completed");
    }
}
