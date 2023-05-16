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
        System.out.println(
            "\n\n##### listener StartedCook : " + cookStarted + "\n\n"
        );

        // Sample Logic //
        Delivery.startedCook(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookEnded'"
    )
    public void wheneverCookEnded_EndedCook(@Payload CookEnded cookEnded) {
        CookEnded event = cookEnded;
        System.out.println(
            "\n\n##### listener EndedCook : " + cookEnded + "\n\n"
        );

        // Sample Logic //
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
        System.out.println(
            "\n\n##### listener InquiriedStatus : " + returnStatus + "\n\n"
        );

        // Sample Logic //
        Delivery.inquiriedStatus(event);
    }
}
