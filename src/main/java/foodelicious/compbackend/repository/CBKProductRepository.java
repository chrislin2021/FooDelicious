package foodelicious.compbackend.repository;

import org.springframework.data.repository.CrudRepository;

import foodelicious.product.model.Product;

public interface CBKProductRepository extends CrudRepository<Product, Integer>{
	
	@Query(value="SELECT * FROM member_data2 WHERE member_mail LIKE %?%", nativeQuery = true)
	List<Product> products
	
	

}
