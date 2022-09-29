package us.mattroberts.waywardcookies.service;

import us.mattroberts.waywardcookies.model.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> fetchAllOrders();

    Order saveOrder(Order order);
}
