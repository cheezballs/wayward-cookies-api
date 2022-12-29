package us.mattroberts.waywardcookies.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class OrderInput {

    @NotBlank
    @Size(max = 100)
    private String firstName;

    @Size(max = 100)
    private String lastName;

    @Size(max = 250)
    @Email
    private String email;

    @Size(max = 15)
    private String phone;

    private String orderDetails;

    @Max(32767) // mysql smallint
    private Integer cookieQuantity;

    @Size(max = 2)
    private String status;
    private String statusDetails;
    private boolean paid;
    private Long dueDate;
    private Long lastUpdatedDate;
    private Long completeDate;
    private Long cancelDate;

    private LogisticsInput logistics;

}
