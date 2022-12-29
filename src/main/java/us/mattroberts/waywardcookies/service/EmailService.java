package us.mattroberts.waywardcookies.service;

import us.mattroberts.waywardcookies.model.entity.Order;

public interface EmailService {

    void notifyNewOrder(Order order);
}
