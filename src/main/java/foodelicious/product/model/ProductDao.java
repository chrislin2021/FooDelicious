package foodelicious.product.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

//	@Query("select product_id from productNum product_id where productId like ?1")
	Product findByProductId(Integer productId);
	
	List<Product> findByProductName(String productName);
	
//	void saveProduct(Product product);
}

