package foodelicious.backend.productPage.repository;

import foodelicious.backend.productPage.model.BkProduct;
import org.springframework.data.repository.CrudRepository;

public interface BkProductRepository extends CrudRepository<BkProduct, Integer> {
}
