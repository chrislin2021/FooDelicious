package foodelicious.cart.service;

import java.util.List;

import foodelicious.product.model.Product;

public interface SearchService {

	List<Product> findByProductNameLike(String productName);

}
