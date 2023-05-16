package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class StatusAlert extends AbstractEvent {

    private Long id;

    public StatusAlert(Order aggregate) {
        super(aggregate);
    }

    public StatusAlert() {
        super();
    }
}
