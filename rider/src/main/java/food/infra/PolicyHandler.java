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
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStarted'"
    )
    public void wheneverCookStarted_StartedCook(
        @Payload CookStarted cookStarted
    ) {
        CookStarted event = cookStarted;

        Delivery.startedCook(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookEnded'"
    )
    public void wheneverCookEnded_EndedCook(@Payload CookEnded cookEnded) {
        CookEnded event = cookEnded;

        Delivery.endedCook(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReturnStatus'"
    )
    public void wheneverReturnStatus_InquiriedStatus(
        @Payload ReturnStatus returnStatus
    ) {
        ReturnStatus event = returnStatus;

        Delivery.inquiriedStatus(event);
    }
}
