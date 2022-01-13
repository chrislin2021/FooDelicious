package foodelicious.compbackend.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import foodelicious.product.model.Product;

public interface CBKProductDaoInterface {
	

	List<Product> getAllProducts(HttpSession session);

	String deleteProduct(Long productId);

	Product findByProductId(Long productId);
	
	String updateProduct(Long productId, Product product);

	// 商品分類搜尋 (not using search box)
	List<Product> findByType(Integer category, Long productCompanyId);

	
	//using search box
	List<Product> findByName(String productName);

	

}
