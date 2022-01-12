package foodelicious.backend.orderPage.controller;

import foodelicious.backend.orderPage.model.BkOrder;
import foodelicious.backend.orderPage.service.BkOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BkOrderController {

    private BkOrderService bkOrderService;

    public BkOrderController(BkOrderService bkOrderService) {
        this.bkOrderService = bkOrderService;
    }

    @GetMapping("/bkorders")
    public List<BkOrder> findAllOrder(){
        return bkOrderService.findAllOrder();
    };
}
