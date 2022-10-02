package us.mattroberts.waywardcookies.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.mattroberts.waywardcookies.model.entity.Order;
import us.mattroberts.waywardcookies.repository.OrderRepository;
import us.mattroberts.waywardcookies.service.OrderService;

import java.util.List;

@Service
@Slf4j
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

    @Override
    public Order fetchById(long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteOrder(Order order) {
        try {
            orderRepository.delete(order);
        } catch (Exception exc) {
            log.error("Unable to delete order: " + order.getId());
            return false;
        }
        return true;
    }
}
