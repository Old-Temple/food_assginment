package food.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class OrderCancelCommand {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long menuId;

    private String menuName;
    private String status;
    private Integer userId;
    private Integer price;
}
