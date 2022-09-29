package us.mattroberts.waywardcookies.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import us.mattroberts.waywardcookies.mapper.OrderMapper;
import us.mattroberts.waywardcookies.model.dto.OrderDto;
import us.mattroberts.waywardcookies.model.entity.Order;
import us.mattroberts.waywardcookies.model.input.OrderInput;
import us.mattroberts.waywardcookies.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<OrderDto> getAllOrders() {
        return mapOrders(orderService.fetchAllOrders());
    }

    @PostMapping("/orders")
    public OrderDto createOrder(OrderInput input) {
        Order order = OrderMapper.mapToEntity(input);
        return OrderMapper.mapFromEntity(orderService.saveOrder(order));
    }

    private List<OrderDto> mapOrders(List<Order> orders) {
        List<OrderDto> orderDtos = new ArrayList<>();
        if (orders != null) {
            for (Order order : orders) {
                orderDtos.add(OrderMapper.mapFromEntity(order));
            }
        }

        return orderDtos;
    }
}