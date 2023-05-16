package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderConfirmed extends AbstractEvent {

    private Long menuId;
    private String menuName;
    private Integer userId;
    private Integer price;
}
