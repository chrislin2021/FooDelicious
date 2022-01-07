package foodelicious.backend.productPage.model;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BkProductDao {


    public List<BkProduct> findAllProduct();

    public List<BkProduct> findAllByName(String productName);

    public List<BkProduct> findByNameAndType(String productName,Integer categories);

    public List<BkProduct> findByType(Integer categories);
}
