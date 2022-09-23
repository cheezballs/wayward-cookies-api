package us.mattroberts.waywardcookies.model.entity;

import us.mattroberts.waywardcookies.model.decode.LogisticsType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ww_order_logistics")
public class Logistics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LogisticsType logisticsType;
    private String details;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private LocalDateTime deliveryDate;
    private LocalDateTime shippedDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Order order;

}
