package us.mattroberts.waywardcookies.model.dto;

import lombok.Getter;
import lombok.Setter;
import us.mattroberts.waywardcookies.model.entity.Logistics;

import java.time.LocalDateTime;

@Getter
@Setter
public class LogisticsDto {

    private long id;
    private String logisticsType;
    private String details;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private LocalDateTime deliveryDate;
    private LocalDateTime shippedDate;

    public void mapFromEntity(Logistics logistics) {
        this.setId(logistics.getId());
        this.setLogisticsType(logistics.getLogisticsType().getCode());
        this.setDetails(logistics.getDetails());
        this.setAddress(logistics.getAddress());
        this.setAddress2(logistics.getAddress2());
        this.setCity(logistics.getCity());
        this.setState(logistics.getState());
        this.setZip(logistics.getZip());
        this.setDeliveryDate(logistics.getDeliveryDate());
        this.setShippedDate(logistics.getShippedDate());
    }
}
