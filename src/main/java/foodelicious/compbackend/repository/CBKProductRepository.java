package foodelicious.compbackend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import foodelicious.backend.productPage.model.BkProduct;
import foodelicious.orders.model.OrdersBean;
import foodelicious.product.model.Product;

@Repository
public interface CBKProductRepository extends JpaRepository<Product, Long> {

	List<Product> findAllByProductCompanyId(Long companyId);

	Product findByProductId(Long productId);

	@Query(value = "SELECT * FROM productNum WHERE categories =? AND product_company_id =?", nativeQuery = true)
	List<Product> findByType(Integer categories, Long productCompanyId);


	@Query(value = "SELECT * FROM productNum WHERE product_keywords LIKE %?%", nativeQuery = true)
	List<Product> findByName(String productName);

	@Query(value = "SELECT * FROM productNum WHERE product_keywords LIKE %?% AND categories =?", nativeQuery = true)
	List<Product> findByNameAndType(String productName, Integer categories);

}
