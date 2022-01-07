package foodelicious.backend.productPage.service;

import foodelicious.backend.productPage.model.BkProduct;

import java.util.List;

public interface BkProductService {

    public List<BkProduct> findAllProduct();

    public List<BkProduct> findAllByName(String productName);

    public List<BkProduct> findByNameAndType(String productName,Integer categories);

    public List<BkProduct> findByType(Integer categories);

}
