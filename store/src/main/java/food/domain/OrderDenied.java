package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderDenied extends AbstractEvent {

    private Long id;

    public OrderDenied(Store aggregate) {
        super(aggregate);
    }

    public OrderDenied() {
        super();
    }
}
