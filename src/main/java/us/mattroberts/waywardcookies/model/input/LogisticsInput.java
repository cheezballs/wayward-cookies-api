package us.mattroberts.waywardcookies.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class LogisticsInput {

    @Size(max = 1)
    private String logisticsType;

    @Size(max = 1000)
    private String details;

    @Size(max = 250)
    private String address;

    @Size(max = 250)
    private String address2;

    @Size(max = 250)
    private String city;

    @Size(max = 2)
    private String state;

    @Size(max = 15)
    private String zip;
    
    private LocalDateTime deliveryDate;
    private LocalDateTime shippedDate;
}
