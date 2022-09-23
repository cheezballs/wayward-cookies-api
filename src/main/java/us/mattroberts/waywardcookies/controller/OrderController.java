package us.mattroberts.waywardcookies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import us.mattroberts.waywardcookies.model.dto.OrderDto;
import us.mattroberts.waywardcookies.model.entity.Order;
import us.mattroberts.waywardcookies.service.OrderService;

import java.util.Collections;
import java.util.List;

@RestController("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public List<OrderDto> getAllOrders() {
        return mapOrder(orderService.fetchAllOrders());
    }

    private List<OrderDto> mapOrder(List<Order> fetchAllOrders) {
        // mapper logic
        return Collections.emptyList();
    }
}
