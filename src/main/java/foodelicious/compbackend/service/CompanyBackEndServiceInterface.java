package foodelicious.compbackend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import foodelicious.orders.model.OrdersBean;
import foodelicious.product.model.Product;


public interface CompanyBackEndServiceInterface {
	
	public List<Product> getAllProducts(HttpSession session);

	

}
