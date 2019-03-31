package introSpring3.service;

import introSpring3.repository.OrdersRepository;
import lesson16.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrdersServiceImplTest {
    @Spy
    @InjectMocks
    private OrdersService ordersService = new OrdersServiceImpl();
    @Mock
    private OrdersRepository ordersRepository;

    private Order order1 = new Order();
    private Order order2 = new Order();

    @Test
    public void testGetAllOrders() {
        List<Order> order = Arrays.asList(new Order[] { order1, order2 });
        doReturn(order).when(ordersRepository).findAll();
        Set<Order> result = ordersService.getAllOrders();
        assertTrue(order.containsAll(result) && result.containsAll(order));
    }

    @Test
    public void testFindOrderById() {
        doReturn(Optional.of(order1)).when(ordersRepository).findById(any());
        Order result = ordersService.findOrderById(BigDecimal.TEN);
        assertEquals(order1, result);
    }

    @Test
    public void testFindByQtyBetween() {
        List<Order> order = Arrays.asList(new Order[] { order1, order2 });
        doReturn(order).when(ordersRepository).findByQtyBetween(any(), any());
        Set<Order> result = ordersService.findByQtyBetween(0, 0);
        assertTrue(order.containsAll(result) && result.containsAll(order));
    }

    @Test
    public void testInsertOrder() {
        doReturn(order1).when(ordersRepository).save(any());
        ordersService.insertOrder(order1);
        verify(ordersRepository, times(1)).save(any());
    }

    @Test
    public void testUpdateOrder() {
        doReturn(order1).when(ordersRepository).save(any());
        ordersService.updateOrder(order1);
        verify(ordersRepository, times(1)).save(any());
    }

    @Test
    public void testDeleteOrder() {
        doNothing().when(ordersRepository).deleteById(any());
        ordersService.deleteOrder(order1.getOrderNum());
        verify(ordersRepository, times(1)).deleteById(any());
    }
}