package foodelicious.backend.productPage.model;

import foodelicious.backend.productPage.repository.BkProductRepository;
import org.springframework.stereotype.Repository;
import foodelicious.backend.productPage.model.BkProduct;

import java.util.List;

@Repository
public class BkProductDaoImpl implements BkProductDao{

    private BkProductRepository bkProductRepository;

    public BkProductDaoImpl(BkProductRepository bkProductRepository) {
        this.bkProductRepository = bkProductRepository;
    }

    @Override
    public List<BkProduct> findAllProduct() {

        List<BkProduct> products = (List<BkProduct>) bkProductRepository.findAll();

        return products;
    }
}
