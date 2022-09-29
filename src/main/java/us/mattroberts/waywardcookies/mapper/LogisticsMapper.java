package us.mattroberts.waywardcookies.mapper;

import us.mattroberts.waywardcookies.model.dto.LogisticsDto;
import us.mattroberts.waywardcookies.model.entity.Logistics;

public class LogisticsMapper {

    public static LogisticsDto mapFromEntity(Logistics logistics) {
        LogisticsDto dto = new LogisticsDto();

        dto.setId(logistics.getId());
        dto.setLogisticsType(logistics.getLogisticsType().getCode());
        dto.setDetails(logistics.getDetails());
        dto.setAddress(logistics.getAddress());
        dto.setAddress2(logistics.getAddress2());
        dto.setCity(logistics.getCity());
        dto.setState(logistics.getState());
        dto.setZip(logistics.getZip());
        dto.setDeliveryDate(logistics.getDeliveryDate());
        dto.setShippedDate(logistics.getShippedDate());

        return dto;
    }

}
