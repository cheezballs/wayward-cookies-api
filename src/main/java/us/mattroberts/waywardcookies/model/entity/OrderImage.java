package us.mattroberts.waywardcookies.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "ww_order_image")
public class OrderImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer orderId;
    private String filePath;
    private String fileName;
    private String comments;

}
