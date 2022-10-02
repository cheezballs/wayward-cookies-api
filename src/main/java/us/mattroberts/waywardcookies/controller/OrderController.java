package us.mattroberts.waywardcookies.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.mattroberts.waywardcookies.model.decode.OrderStatus;
import us.mattroberts.waywardcookies.model.dto.OrderDto;
import us.mattroberts.waywardcookies.model.entity.Order;
import us.mattroberts.waywardcookies.model.input.OrderInput;
import us.mattroberts.waywardcookies.service.OrderService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return new ResponseEntity<>(mapOrders(orderService.fetchAllOrders()), HttpStatus.OK);
    }

    @PostMapping(value = "/orders")
    public ResponseEntity<OrderDto> createOrder(@RequestBody @Valid OrderInput orderInput) {
        Order order = new Order();
        OrderDto response = new OrderDto();
        order.updateData(orderInput);

        order.setStatus(OrderStatus.SUBMITTED);
        order.setPaid(false);
        order.setCreatedDate(LocalDateTime.now());

        order = orderService.saveOrder(order);
        response.mapFromEntity(order);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(value = "/orders/{id}")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody @Valid OrderInput orderInput, @PathVariable int id) {
        OrderDto response = new OrderDto();
        Order originalOrder = orderService.fetchById(id);

        if (originalOrder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        originalOrder.updateData(orderInput);
        originalOrder.setLastUpdatedDate(LocalDateTime.now());

        originalOrder = orderService.saveOrder(originalOrder);
        response.mapFromEntity(originalOrder);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable int id) {
        Order originalOrder = orderService.fetchById(id);

        if (originalOrder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return orderService.deleteOrder(originalOrder) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private List<OrderDto> mapOrders(List<Order> orders) {
        List<OrderDto> orderDtos = new ArrayList<>();
        if (orders != null) {
            for (Order order : orders) {
                OrderDto dto = new OrderDto();
                dto.mapFromEntity(order);
                orderDtos.add(dto);
            }
        }

        return orderDtos;
    }
}