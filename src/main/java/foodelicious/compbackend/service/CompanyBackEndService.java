package foodelicious.compbackend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import foodelicious.cart.service.CartService;
import foodelicious.compbackend.model.CBKOrderDaoInterface;
import foodelicious.compbackend.model.CBKProductDaoInterface;
import foodelicious.product.model.Product;

@Service
@Transactional
public class CompanyBackEndService implements CompanyBackEndServiceInterface{
	
	private CBKProductDaoInterface cbkProductDaoInterface;
	
	private CBKOrderDaoInterface cbkOrderDaoInterface;
	
	private CartService cartService;
	
	public CompanyBackEndService (final CBKProductDaoInterface cbkProductDaoInterface,CBKOrderDaoInterface cbkOrderDaoInterface, CartService cartService) {
		this.cbkProductDaoInterface = cbkProductDaoInterface;
		this.cbkOrderDaoInterface = cbkOrderDaoInterface;
		this.cartService = cartService;
	}
	
	public List<Product> getAllProducts(HttpSession session){
		List<Product> products = cbkProductDaoInterface.getAllProducts(session);
		return products;
	}

	
	@Override
	public Product findByProductId(Long productId) {
		Product product = cbkProductDaoInterface.findByProductId(productId);
		return product;
	}
	
	@Override
	public List<Product> findByType(Integer categories, Long productCompanyId) {
		List <Product> catProd = cbkProductDaoInterface.findByType(categories, productCompanyId);
		return catProd;
	}
	

	@Override
	public String updateProduct(Long productId, Product product) {
		
		return cbkProductDaoInterface.updateProduct(productId, product);
	}
	
	
	@Override
	public String deleteProduct(Long productId) {
		
		return cbkProductDaoInterface.deleteProduct(productId);
		
	}

	
	
	

	
	

}
