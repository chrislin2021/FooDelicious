package foodelicious.compbackend.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import foodelicious.product.model.Product;

public interface CBKProductDaoInterface {
	

	List<Product> getAllProducts(HttpSession session);

	String deleteProduct(Integer productId);

	Product findByProductId(Integer productId);
	
	String updateProduct(Integer productId, Product product);
	

	

}
