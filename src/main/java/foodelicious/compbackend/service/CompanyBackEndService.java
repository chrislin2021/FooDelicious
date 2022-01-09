package foodelicious.compbackend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import foodelicious.compbackend.model.CBKOrderDaoInterface;
import foodelicious.compbackend.model.CBKProductDaoInterface;
import foodelicious.orders.model.OrdersBean;
import foodelicious.product.model.Product;

@Service
@Transactional
public class CompanyBackEndService implements CompanyBackEndServiceInterface{
	
	private CBKProductDaoInterface cbkProductDaoInterface;
	
	private CBKOrderDaoInterface cbkOrderDaoInterface;
	
	public CompanyBackEndService (final CBKProductDaoInterface cbkProductDaoInterface,CBKOrderDaoInterface cbkOrderDaoInterface) {
		this.cbkProductDaoInterface = cbkProductDaoInterface;
		this.cbkOrderDaoInterface = cbkOrderDaoInterface;
	}
	
	public List<Product> getAllProducts(HttpSession session){
		List<Product> products = cbkProductDaoInterface.getAllProducts(session);
		return products;
	}

	@Override
	public Product findByProductId(Integer productId) {
		Product product = cbkProductDaoInterface.findByProductId(productId);
		return product;
	}

	@Override
	public String updateProduct(Integer productId, Product product) {
		
		return null;
	}

	
	

}
