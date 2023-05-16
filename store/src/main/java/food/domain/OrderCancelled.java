package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long menuId;
    private String menuName;
    private String status;
    private Integer userId;
    private Integer price;

    public OrderCancelled(Store aggregate) {
        super(aggregate);
    }

    public OrderCancelled() {
        super();
    }
}
