package introSpring3.repository;

import lesson16.entity.Order;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Order, BigDecimal> {

    @Cacheable("orderCashed")
    List<Order> findByQtyBetween(BigDecimal minQty, BigDecimal maxQty);
//    List<Order> findByCustomer_CompanyLike(String str);
}
