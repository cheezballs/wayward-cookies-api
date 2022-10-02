package us.mattroberts.waywardcookies.model.dto;

import lombok.Getter;
import lombok.Setter;
import us.mattroberts.waywardcookies.model.entity.Order;

import java.time.LocalDateTime;
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
    private LocalDateTime dueDate;
    private LocalDateTime lastUpdatedDate;
    private LocalDateTime createdDate;
    private LocalDateTime completeDate;
    private LocalDateTime cancelDate;
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
        dueDate = order.getDueDate();
        lastUpdatedDate = order.getLastUpdatedDate();
        createdDate = order.getCreatedDate();
        completeDate = order.getCompleteDate();
        cancelDate = order.getCancelDate();

        if (order.getLogistics() != null) {
            logistics = new LogisticsDto();
            logistics.mapFromEntity(order.getLogistics());
        }
    }

}
