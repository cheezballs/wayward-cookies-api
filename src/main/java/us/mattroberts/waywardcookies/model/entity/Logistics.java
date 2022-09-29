package us.mattroberts.waywardcookies.model.entity;

import lombok.Getter;
import us.mattroberts.waywardcookies.model.decode.LogisticsType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "ww_order_logistics")
public class Logistics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "type_code")
    private LogisticsType logisticsType;
    private String details;
    private String address;
    @Column(name = "address_2")
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
