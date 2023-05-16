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
// @RequestMapping(value="/stores")
@Transactional
public class StoreController {

    @Autowired
    StoreRepository storeRepository;

    @RequestMapping(
        value = "stores/{id}/acceptorder",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Store acceptOrder(
        @PathVariable(value = "id") Long id,
        @RequestBody AcceptOrderCommand acceptOrderCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /store/acceptOrder  called #####");
        Optional<Store> optionalStore = storeRepository.findById(id);

        optionalStore.orElseThrow(() -> new Exception("No Entity Found"));
        Store store = optionalStore.get();
        store.acceptOrder(acceptOrderCommand);

        storeRepository.save(store);
        return store;
    }

    @RequestMapping(
        value = "stores/{id}/startcook",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Store startCook(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /store/startCook  called #####");
        Optional<Store> optionalStore = storeRepository.findById(id);

        optionalStore.orElseThrow(() -> new Exception("No Entity Found"));
        Store store = optionalStore.get();
        store.startCook();

        storeRepository.save(store);
        return store;
    }

    @RequestMapping(
        value = "stores/{id}/endcook",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Store endCook(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /store/endCook  called #####");
        Optional<Store> optionalStore = storeRepository.findById(id);

        optionalStore.orElseThrow(() -> new Exception("No Entity Found"));
        Store store = optionalStore.get();
        store.endCook();

        storeRepository.save(store);
        return store;
    }
}
