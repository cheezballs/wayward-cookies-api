package us.mattroberts.waywardcookies.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.mattroberts.waywardcookies.model.entity.Order;
import us.mattroberts.waywardcookies.repository.OrderRepository;
import us.mattroberts.waywardcookies.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> fetchAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
