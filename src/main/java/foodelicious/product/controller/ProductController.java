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
	
	@GetMapping(path = "/product")
	public String product() {

		return "app.Product";
	}

	@GetMapping(path = "/productdetail")
	public String productdetail() {

		return "app.Cproductdetail";
	}
	
	@GetMapping("/product")
	public ModelAndView viewStatus(ModelAndView mav,@RequestParam(name="p", defaultValue="1") int pageNumber) {
		
		Page<Product> page = productService.getPage(pageNumber);
		mav.getModel().put("page", page);
		
		mav.setViewName("app.viewStatus");
		
		return mav;
	}
}
