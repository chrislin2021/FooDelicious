package foodelicious.compbackend.product.repository;

import org.springframework.data.repository.CrudRepository;

import foodelicious.product.model.Product;

public interface CBKProductCrudRepository extends CrudRepository<Product, Integer>{

}
