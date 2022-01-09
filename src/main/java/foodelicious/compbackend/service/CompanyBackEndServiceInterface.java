package foodelicious.compbackend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import foodelicious.backend.memberpage.model.BkMember;
import foodelicious.orders.model.OrdersBean;
import foodelicious.product.model.Product;


public interface CompanyBackEndServiceInterface {
	
	public List<Product> getAllProducts(HttpSession session);

	public Product findByProductId(Integer productId);
	
	public String updateProduct(Integer productId, Product product);


}
