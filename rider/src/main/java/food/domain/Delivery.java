package food.domain;

import food.RiderApplication;
import food.domain.FoodCooked;
import food.domain.InsertDelivery;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long menuId;

    private String menuName;

    private String status;

    private Integer userId;

    private Integer price;

    @PostPersist
    public void onPostPersist() {
        InsertDelivery insertDelivery = new InsertDelivery(this);
        insertDelivery.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        FoodCooked foodCooked = new FoodCooked(this);
        foodCooked.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public void inquiryStatus() {
        StatusInquiried statusInquiried = new StatusInquiried(this);
        statusInquiried.publishAfterCommit();
    }

    public void startDelivery() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }

    public void completeDelivery() {
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }

    public static void startedCook(CookStarted cookStarted) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        InsertDelivery insertDelivery = new InsertDelivery(delivery);
        insertDelivery.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            InsertDelivery insertDelivery = new InsertDelivery(delivery);
            insertDelivery.publishAfterCommit();

         });
        */

    }

    public static void endedCook(CookEnded cookEnded) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        FoodCooked foodCooked = new FoodCooked(delivery);
        foodCooked.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookEnded.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            FoodCooked foodCooked = new FoodCooked(delivery);
            foodCooked.publishAfterCommit();

         });
        */

    }

    public static void inquiriedStatus(ReturnStatus returnStatus) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(returnStatus.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

    }
}
