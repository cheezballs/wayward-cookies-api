package us.mattroberts.waywardcookies.model.entity;

import lombok.Getter;
import lombok.Setter;
import us.mattroberts.waywardcookies.model.decode.OrderStatus;
import us.mattroberts.waywardcookies.model.input.OrderInput;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ww_order")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String orderDetails;
    private Integer cookieQuantity;
    @Column(name = "status_code")
    private OrderStatus status;
    private String statusDetails;
    private boolean paid;
    private LocalDateTime dueDate;
    private LocalDateTime lastUpdatedDate;
    private LocalDateTime createdDate;
    private LocalDateTime completeDate;
    private LocalDateTime cancelDate;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Logistics logistics;

//    @OneToMany
//    private Set<OrderImage> images;

    public void updateData(OrderInput input) {
        firstName = input.getFirstName();
        lastName = input.getLastName();
        email = input.getEmail();
        phone = input.getPhone();
        orderDetails = input.getOrderDetails();
        cookieQuantity = input.getCookieQuantity();
        if (input.getStatus() != null) {
            status = OrderStatus.findForCode(input.getStatus());
        }
        paid = input.isPaid();
        dueDate = input.getDueDate();
        lastUpdatedDate = input.getLastUpdatedDate();
        completeDate = input.getCompleteDate();
        cancelDate = input.getCancelDate();

        if (input.getLogistics() != null) {
            if (logistics == null) {
                logistics = new Logistics();
            }
            logistics.updateData(input.getLogistics());
        }
    }
}
