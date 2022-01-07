package foodelicious.backend.productPage.controller;

import foodelicious.backend.productPage.model.BkProduct;
import foodelicious.backend.productPage.repository.BkProductRepository;
import foodelicious.backend.productPage.service.BkProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/bkproducts/{productName}")
    public List<BkProduct> findAllByName(@PathVariable String productName){
        return bkProductService.findAllByName(productName);
    }

    @GetMapping("/bkproducts/{productName}/{categories}")
    public List<BkProduct> findByNameAndType(@PathVariable String productName,
                                             @PathVariable Integer categories){
        return  bkProductService.findByNameAndType(productName, categories);
    }

    @GetMapping("/bkproducts/search/{categories}")
    public List<BkProduct> findAllByName(@PathVariable Integer categories){
        return bkProductService.findByType(categories);
    }
}
