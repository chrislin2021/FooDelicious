package foodelicious.backend.productPage.service;

import foodelicious.backend.productPage.model.BkProduct;
import foodelicious.backend.productPage.model.BkProductDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BkProductServiceImpl implements BkProductService{

    private BkProductDao bkProductDao;

    public BkProductServiceImpl(BkProductDao bkProductDao) {
        this.bkProductDao = bkProductDao;
    }

    @Override
    public List<BkProduct> findAllProduct() {
        return bkProductDao.findAllProduct();
    }
}
