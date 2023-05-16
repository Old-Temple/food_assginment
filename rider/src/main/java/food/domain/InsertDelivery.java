package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class InsertDelivery extends AbstractEvent {

    private Long menuId;
    private String menuName;
    private String status;
    private Integer userId;
    private Integer price;

    public InsertDelivery(Delivery aggregate) {
        super(aggregate);
    }

    public InsertDelivery() {
        super();
    }
}
