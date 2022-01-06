package foodelicious.compbackend.model;

import java.util.List;


import foodelicious.product.model.Product;

public interface CBKProductDaoInterface {
	
	

	List<Product> getAllProducts(Long id);
	
	

}
