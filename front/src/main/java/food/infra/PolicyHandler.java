package food.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import food.config.kafka.KafkaProcessor;
import food.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderAccepted'"
    )
    public void wheneverOrderAccepted_AcceptedOrder(
        @Payload OrderAccepted orderAccepted
    ) {
        OrderAccepted event = orderAccepted;
        System.out.println(
            "\n\n##### listener AcceptedOrder : " + orderAccepted + "\n\n"
        );

        // Sample Logic //
        Order.acceptedOrder(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderDenied'"
    )
    public void wheneverOrderDenied_DeniedOrder(
        @Payload OrderDenied orderDenied
    ) {
        OrderDenied event = orderDenied;
        System.out.println(
            "\n\n##### listener DeniedOrder : " + orderDenied + "\n\n"
        );

        // Sample Logic //
        Order.deniedOrder(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReturnStatus'"
    )
    public void wheneverReturnStatus_InquiriedStatus(
        @Payload ReturnStatus returnStatus
    ) {
        ReturnStatus event = returnStatus;
        System.out.println(
            "\n\n##### listener InquiriedStatus : " + returnStatus + "\n\n"
        );

        // Sample Logic //
        Order.inquiriedStatus(event);
    }
}
