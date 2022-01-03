package foodelicious.compbackend.service;

import java.util.List;
import foodelicious.orders.model.OrdersBean;
import foodelicious.product.model.Product;


public interface CompanyBackEndServiceInterface {
	
	public List<Product> getAllProducts();
	
	public List<OrdersBean> getAllOrders();

}
