package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderDenied extends AbstractEvent {

    private Long menuId;
    private String menuName;
    private String status;
    private Integer userId;
    private Integer price;

    public OrderDenied(Order aggregate) {
        super(aggregate);
    }

    public OrderDenied() {
        super();
    }
}
