package us.mattroberts.waywardcookies.service.impl;

import org.springframework.stereotype.Service;
import us.mattroberts.waywardcookies.model.entity.Order;
import us.mattroberts.waywardcookies.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> fetchAllOrders() {
        return null;
    }
}
