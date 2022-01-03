package foodelicious.compbackendrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import foodelicious.compbackend.service.CompanyBackEndServiceInterface;
import foodelicious.orders.model.OrdersBean;
import foodelicious.product.model.Product;

@RestController
public class CompanyBackEndRestController {
	
	// forgot why we're using interface instead of class? 
	private final CompanyBackEndServiceInterface cbkServiceInterface;
	
	
	// use the final method instead of @autowired. it's the GOOD Way of writing it 跟spring DI有關 Search for spring DI 好的 壞的 醜的
	public CompanyBackEndRestController(final CompanyBackEndServiceInterface cbkServiceInterface) {
        this.cbkServiceInterface = cbkServiceInterface;
    }
	
	
	@GetMapping("/companyProducts") // Important! /companyProduct是controller, /companyProducts 是 RESTController
	public List<Product> findAllProducts() {
		
		List <Product> products = cbkServiceInterface.getAllProducts();
		return products;
	}
	
	
	@GetMapping("/companyOrders")
	public List<OrdersBean> findAllOrders() {
		return null;
	}

}
