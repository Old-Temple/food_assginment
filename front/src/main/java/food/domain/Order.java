package food.domain;

import food.FrontApplication;
import food.domain.OrderAccepted;
import food.domain.OrderConfirmed;
import food.domain.OrderDenied;
import food.domain.StatusAlert;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long menuId;

    private String menuName;

    private String status;

    private Integer userId;

    private Integer price;

    @PostPersist
    public void onPostPersist() {
        OrderConfirmed orderConfirmed = new OrderConfirmed(this);
        orderConfirmed.publishAfterCommit();

        // StatusAlert statusAlert = new StatusAlert(this);
        // statusAlert.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        // OrderAccepted orderAccepted = new OrderAccepted(this);
        // orderAccepted.publishAfterCommit();

        // OrderDenied orderDenied = new OrderDenied(this);
        // orderDenied.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public void orderCancel(OrderCancelCommand orderCancelCommand) {
        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();
    }

    public void inquiryStatus() {
        StatusInquiried statusInquiried = new StatusInquiried(this);
        statusInquiried.publishAfterCommit();
    }

    public static void acceptedOrder(OrderAccepted orderAcceptedP) {
        // /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        // OrderAccepted orderAccepted = new OrderAccepted(order);
        // orderAccepted.publishAfterCommit();
        // */

        /** Example 2:  finding and process
        
        repository().findById(orderAccepted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            OrderAccepted orderAccepted = new OrderAccepted(order);
            orderAccepted.publishAfterCommit();

         });
        */

    }

    public static void deniedOrder(OrderDenied orderDenied) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        OrderDenied orderDenied = new OrderDenied(order);
        orderDenied.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderDenied.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            OrderDenied orderDenied = new OrderDenied(order);
            orderDenied.publishAfterCommit();

         });
        */

    }

    public static void inquiriedStatus(ReturnStatus returnStatus) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(returnStatus.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
}
