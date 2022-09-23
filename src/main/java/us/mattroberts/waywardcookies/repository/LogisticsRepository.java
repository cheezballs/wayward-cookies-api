package us.mattroberts.waywardcookies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import us.mattroberts.waywardcookies.model.entity.Logistics;

public interface LogisticsRepository extends JpaRepository<Logistics, Long> {
}
