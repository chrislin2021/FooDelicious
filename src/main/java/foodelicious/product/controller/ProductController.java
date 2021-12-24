package foodelicious.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import foodelicious.product.model.Product;
import foodelicious.product.model.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
}