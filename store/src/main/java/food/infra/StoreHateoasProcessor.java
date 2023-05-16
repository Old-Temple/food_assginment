package food.infra;

import food.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class StoreHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Store>> {

    @Override
    public EntityModel<Store> process(EntityModel<Store> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/acceptorder")
                .withRel("acceptorder")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/startcook")
                .withRel("startcook")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/endcook")
                .withRel("endcook")
        );

        return model;
    }
}
