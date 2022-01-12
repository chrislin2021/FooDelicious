package foodelicious.compbackend.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import foodelicious.product.model.Product;

public interface CBKProductDaoInterface {
	

	List<Product> getAllProducts(HttpSession session);

	String deleteProduct(Long productId);

	Product findByProductId(Long productId);
	
	String updateProduct(Long productId, Product product);
	

	

}
