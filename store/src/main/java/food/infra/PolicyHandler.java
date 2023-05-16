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
    StoreRepository storeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderConfirmed'"
    )
    public void wheneverOrderConfirmed_ConfirmedOrder(
        @Payload OrderConfirmed orderConfirmed
    ) {
        OrderConfirmed event = orderConfirmed;
        System.out.println(
            "\n\n##### listener ConfirmedOrder : " + orderConfirmed + "\n\n"
        );

        // Sample Logic //
        Store.confirmedOrder(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCancelled'"
    )
    public void wheneverOrderCancelled_CancelledOrder(
        @Payload OrderCancelled orderCancelled
    ) {
        OrderCancelled event = orderCancelled;
        System.out.println(
            "\n\n##### listener CancelledOrder : " + orderCancelled + "\n\n"
        );

        // Sample Logic //
        Store.cancelledOrder(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StatusInquiried'"
    )
    public void wheneverStatusInquiried_CallStatus(
        @Payload StatusInquiried statusInquiried
    ) {
        StatusInquiried event = statusInquiried;
        System.out.println(
            "\n\n##### listener CallStatus : " + statusInquiried + "\n\n"
        );

        // Sample Logic //
        Store.callStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StatusInquiried'"
    )
    public void wheneverStatusInquiried_CallStatus(
        @Payload StatusInquiried statusInquiried
    ) {
        StatusInquiried event = statusInquiried;
        System.out.println(
            "\n\n##### listener CallStatus : " + statusInquiried + "\n\n"
        );

        // Sample Logic //
        Store.callStatus(event);
    }
}
