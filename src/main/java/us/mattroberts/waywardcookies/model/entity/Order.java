package us.mattroberts.waywardcookies.model.entity;

import lombok.Getter;
import lombok.Setter;
import us.mattroberts.waywardcookies.model.decode.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "ww_order")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String orderDetails;
    private Integer cookieQuantity;
    @Column(name = "status_code")
    private OrderStatus status;
    private String statusDetails;
    private Boolean paid;
    private LocalDateTime dueDate;
    private LocalDateTime lastUpdatedDate;
    private LocalDateTime createdDate;
    private LocalDateTime completeDate;
    private LocalDateTime cancelDate;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Logistics logistics;

    @OneToMany
    private Set<OrderImage> images;
}
