package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderInsert extends AbstractEvent {

    private Long menuId;
    private String status;
    private String menuName;
    private Integer userId;
    private Integer price;

    public OrderInsert(Store aggregate) {
        super(aggregate);
    }

    public OrderInsert() {
        super();
    }
}
