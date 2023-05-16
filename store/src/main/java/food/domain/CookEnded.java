package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookEnded extends AbstractEvent {

    private Long menuId;
    private String menuName;
    private String status;
    private Integer userId;
    private Integer price;

    public CookEnded(Store aggregate) {
        super(aggregate);
    }

    public CookEnded() {
        super();
    }
}
