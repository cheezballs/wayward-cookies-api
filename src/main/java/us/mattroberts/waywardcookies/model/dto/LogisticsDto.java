package us.mattroberts.waywardcookies.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LogisticsDto {

    private int id;
    private String logisticsType;
    private String details;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private LocalDateTime deliveryDate;
    private LocalDateTime shippedDate;
}
