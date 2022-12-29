package us.mattroberts.waywardcookies.model.dto;

import lombok.Getter;
import lombok.Setter;
import us.mattroberts.waywardcookies.model.entity.Logistics;

import java.time.ZoneId;
import java.time.ZonedDateTime;

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
    private long deliveryDate;
    private long shippedDate;

    public void mapFromEntity(Logistics logistics) {
        this.setId(logistics.getId());
        this.setLogisticsType(logistics.getLogisticsType().getCode());
        this.setDetails(logistics.getDetails());
        this.setAddress(logistics.getAddress());
        this.setAddress2(logistics.getAddress2());
        this.setCity(logistics.getCity());
        this.setState(logistics.getState());
        this.setZip(logistics.getZip());

        ZonedDateTime zdt;
        if (logistics.getDeliveryDate() != null) {
            zdt = ZonedDateTime.of(logistics.getDeliveryDate(), ZoneId.systemDefault());
            this.setDeliveryDate(zdt.toInstant().toEpochMilli());
        }

        if (logistics.getShippedDate() != null) {
            zdt = ZonedDateTime.of(logistics.getShippedDate(), ZoneId.systemDefault());
            this.setShippedDate(zdt.toInstant().toEpochMilli());
        }
    }
}