package foodelicious.backend.productPage.controller;

import foodelicious.backend.productPage.model.BkProduct;
import foodelicious.backend.productPage.service.BkProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BkProductController {

    private BkProductService bkProductService;

    public BkProductController(BkProductService bkProductService) {
        this.bkProductService = bkProductService;
    }

    @GetMapping("/bkproducts")
    public List<BkProduct> findAllProduct(){
        return bkProductService.findAllProduct();
    }
}
