package food.domain;

import food.StoreApplication;
import food.domain.OrderCancelled;
import food.domain.OrderDenied;
import food.domain.OrderInsert;
import food.domain.ReturnStatus;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Store_table")
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long menuId;

    private String menuName;

    private String status;

    private Integer userId;

    private Integer price;

    @PostPersist
    public void onPostPersist() {
        // OrderDenied orderDenied = new OrderDenied(this);
        // orderDenied.publishAfterCommit();

        // OrderInsert orderInsert = new OrderInsert(this);
        // orderInsert.publishAfterCommit();

        // ReturnStatus returnStatus = new ReturnStatus(this);
        // returnStatus.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        // OrderCancelled orderCancelled = new OrderCancelled(this);
        // orderCancelled.publishAfterCommit();
    }

    public static StoreRepository repository() {
        StoreRepository storeRepository = StoreApplication.applicationContext.getBean(
            StoreRepository.class
        );
        return storeRepository;
    }

    public void acceptOrder(AcceptOrderCommand acceptOrderCommand) {
        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();
    }

    public void startCook() {
        this.status = "StartCook";
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();
    }

    public void endCook() {
        this.status = "EndCook";
        CookEnded cookEnded = new CookEnded(this);
        cookEnded.publishAfterCommit();
    }

    public static void confirmedOrder(OrderConfirmed orderConfirmed) {
        // /** Example 1:  new item 
        Store store = new Store();
        store.setMenuId(orderConfirmed.getMenuId());
        store.setMenuName(orderConfirmed.getMenuName());
        store.setPrice(orderConfirmed.getPrice());
        store.setStatus("Confirmed");
        store.setUserId(orderConfirmed.getUserId());
        repository().save(store);

        OrderInsert orderInsert = new OrderInsert(store);
        orderInsert.publishAfterCommit();
        // */

        /** Example 2:  finding and process
        
        repository().findById(orderConfirmed.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);

            OrderInsert orderInsert = new OrderInsert(store);
            orderInsert.publishAfterCommit();

         });
        */

    }

    public static void cancelledOrder(OrderCancelled orderCancelled) {
        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        OrderCancelled orderCancelled = new OrderCancelled(store);
        orderCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);

            OrderCancelled orderCancelled = new OrderCancelled(store);
            orderCancelled.publishAfterCommit();

         });
        */

    }

    public static void callStatus(StatusInquiried statusInquiried) {
        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        ReturnStatus returnStatus = new ReturnStatus(store);
        returnStatus.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(statusInquiried.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);

            ReturnStatus returnStatus = new ReturnStatus(store);
            returnStatus.publishAfterCommit();

         });
        */

    }
}
