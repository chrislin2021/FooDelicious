package foodelicious.compbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import foodelicious.product.model.Product;

public interface CBKProductRepository extends CrudRepository<Product, Integer>{
	
	
	
	

}
