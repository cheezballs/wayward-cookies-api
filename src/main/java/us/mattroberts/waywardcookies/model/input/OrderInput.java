package us.mattroberts.waywardcookies.model.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderInput {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String orderDetails;
    private Integer cookieQuantity;
    private String status;
    private String statusDetails;
    private Boolean paid;
    private LocalDateTime dueDate;
    private LocalDateTime lastUpdatedDate;
    private LocalDateTime createdDate;
    private LocalDateTime completeDate;
    private LocalDateTime cancelDate;
    
}
