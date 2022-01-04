package foodelicious.compbackend.repository;

import org.springframework.data.repository.CrudRepository;

import foodelicious.product.model.Product;

public interface CBKProductRepository extends CrudRepository<Product, Integer>{
	
	

}
