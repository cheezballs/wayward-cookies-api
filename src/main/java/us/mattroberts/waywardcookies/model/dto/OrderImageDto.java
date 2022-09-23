package us.mattroberts.waywardcookies.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderImageDto {
    private int orderId;
    private String filePath;
    private String fileName;
    private String comments;
}
