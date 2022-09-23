package us.mattroberts.waywardcookies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import us.mattroberts.waywardcookies.model.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
