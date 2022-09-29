package us.mattroberts.waywardcookies.mapper;

import us.mattroberts.waywardcookies.model.decode.OrderStatus;
import us.mattroberts.waywardcookies.model.dto.OrderDto;
import us.mattroberts.waywardcookies.model.entity.Order;
import us.mattroberts.waywardcookies.model.input.OrderInput;

public class OrderMapper {

    public static OrderDto mapFromEntity(Order order) {
        OrderDto dto = new OrderDto();

        dto.setId(order.getId());
        dto.setFirstName(order.getFirstName());
        dto.setLastName(order.getLastName());
        dto.setEmail(order.getEmail());
        dto.setPhone(order.getPhone());
        dto.setOrderDetails(order.getOrderDetails());
        dto.setCookieQuantity(order.getCookieQuantity());
        dto.setStatus(order.getStatus().getCode());
        dto.setPaid(order.getPaid());
        dto.setDueDate(order.getDueDate());
        dto.setLastUpdatedDate(order.getLastUpdatedDate());
        dto.setCreatedDate(order.getCreatedDate());
        dto.setCompleteDate(order.getCompleteDate());
        dto.setCancelDate(order.getCancelDate());

        if (order.getLogistics() != null) {
            dto.setLogistics(LogisticsMapper.mapFromEntity(order.getLogistics()));
        }

        // TODO: map images images

        return dto;
    }

    public static Order mapToEntity(OrderInput input) {
        Order order = new Order();

        order.setFirstName(input.getFirstName());
        order.setLastName(input.getLastName());
        order.setEmail(input.getEmail());
        order.setPhone(input.getPhone());
        order.setOrderDetails(input.getOrderDetails());
        order.setCookieQuantity(input.getCookieQuantity());
        order.setStatus(OrderStatus.findForCode(input.getStatus()));
        order.setPaid(input.getPaid());
        order.setDueDate(input.getDueDate());
        order.setLastUpdatedDate(input.getLastUpdatedDate());
        order.setCreatedDate(input.getCreatedDate());
        order.setCompleteDate(input.getCompleteDate());
        order.setCancelDate(input.getCancelDate());

        return order;
    }
}
