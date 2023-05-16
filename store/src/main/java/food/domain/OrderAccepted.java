package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderAccepted extends AbstractEvent {

    private Long menuId;
    private String status;

    public OrderAccepted(Store aggregate) {
        super(aggregate);
    }

    public OrderAccepted() {
        super();
    }
}
