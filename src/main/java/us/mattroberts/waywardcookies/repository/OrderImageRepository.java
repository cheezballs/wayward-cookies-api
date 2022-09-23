package us.mattroberts.waywardcookies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import us.mattroberts.waywardcookies.model.entity.OrderImage;

public interface OrderImageRepository extends JpaRepository<OrderImage, Long> {
}
