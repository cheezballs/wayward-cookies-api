package us.mattroberts.waywardcookies.model.dto;

import lombok.Getter;
import lombok.Setter;
import us.mattroberts.waywardcookies.model.entity.Order;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDto {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String orderDetails;
    private Integer cookieQuantity;
    private String status;
    private String statusDetails;
    private boolean paid;
    private long dueDate;
    private long lastUpdatedDate;
    private long createdDate;
    private long completeDate;
    private long cancelDate;
    private LogisticsDto logistics;
    private List<OrderImageDto> images;

    public void mapFromEntity(Order order) {
        id = order.getId();
        firstName = order.getFirstName();
        lastName = order.getLastName();
        email = order.getEmail();
        phone = order.getPhone();
        orderDetails = order.getOrderDetails();
        cookieQuantity = order.getCookieQuantity();
        status = order.getStatus().getCode();
        statusDetails = order.getStatusDetails();
        paid = order.isPaid();

        ZonedDateTime zdt = ZonedDateTime.of(order.getCreatedDate(), ZoneId.systemDefault());
        createdDate = zdt.toInstant().toEpochMilli();

        if (order.getCompleteDate() != null) {
            zdt = ZonedDateTime.of(order.getCompleteDate(), ZoneId.systemDefault());
            completeDate = zdt.toInstant().toEpochMilli();
        }

        if (order.getDueDate() != null) {
            zdt = ZonedDateTime.of(order.getDueDate(), ZoneId.systemDefault());
            dueDate = zdt.toInstant().toEpochMilli();
        }

        if (order.getLastUpdatedDate() != null) {
            zdt = ZonedDateTime.of(order.getLastUpdatedDate(), ZoneId.systemDefault());
            lastUpdatedDate = zdt.toInstant().toEpochMilli();
        }

        if (order.getCancelDate() != null) {
            zdt = ZonedDateTime.of(order.getCancelDate(), ZoneId.systemDefault());
            cancelDate = zdt.toInstant().toEpochMilli();
        }

        if (order.getLogistics() != null) {
            logistics = new LogisticsDto();
            logistics.mapFromEntity(order.getLogistics());
        }
    }

}
