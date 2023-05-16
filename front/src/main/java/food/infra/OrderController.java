package food.infra;

import food.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/orders")
@Transactional
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(
        value = "orders/{id}/ordercancel",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order orderCancel(
        @PathVariable(value = "id") Long id,
        @RequestBody OrderCancelCommand orderCancelCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/orderCancel  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.orderCancel(orderCancelCommand);

        orderRepository.save(order);
        return order;
    }

    @RequestMapping(
        value = "orders/{id}/inquirystatus",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order inquiryStatus(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/inquiryStatus  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.inquiryStatus();

        orderRepository.save(order);
        return order;
    }
}
