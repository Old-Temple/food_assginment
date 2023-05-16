package food.infra;

import food.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DeliveryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Delivery>> {

    @Override
    public EntityModel<Delivery> process(EntityModel<Delivery> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/inquirystatus")
                .withRel("inquirystatus")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/startdelivery")
                .withRel("startdelivery")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/completedelivery"
                )
                .withRel("completedelivery")
        );

        return model;
    }
}
