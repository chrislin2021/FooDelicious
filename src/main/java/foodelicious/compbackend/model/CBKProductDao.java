package foodelicious.compbackend.model;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import foodelicious.compbackend.service.CompanyBackEndServiceInterface;
import foodelicious.orders.model.OrdersBean;
import foodelicious.product.model.Product;


@Repository
@Transactional
public class CBKProductDao implements CBKProductDaoInterface{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Product> getAllProducts() {
		
		return null;
	}

	public List<OrdersBean> getAllOrders() {
		
		return null;
	}
	
	
	

}
