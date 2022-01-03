package foodelicious.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import foodelicious.product.model.Product;
import foodelicious.product.model.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
//	@GetMapping("/Product")
//	public String productpage() {
//		return "app.Product";
//	}
	//show all data
	@GetMapping("/Product")
	public String  productlist(String productName,Model m) {
		List<Product> pros = productService.findAll();
		m.addAttribute("pros", pros);
		return "app.Product";
	}
	
	//create model Attribute to bind for data
	@GetMapping("/showNewProductForm")
	public String showNewProductForm(Model m) {
		Product product = new Product();
		m.addAttribute("product",product);
		return "app.BackendProductAdd";
	}
	
	//save product to database
//	@PostMapping("/saveProduct")
//	public String saveProduct(@ModelAttribute("product") Product product) {
//		productService.saveProduct(product);
//		return "redirect:/";
//	}
	
//	@GetMapping("/product/{id}")
//	public List<Product> product(@PathVariable Integer productId, Model m) {
//		ArrayList<Product> pros = (ArrayList<Product>) productService.findAllByProductName();
//		m.addAttribute("pros", pros);
//		return pros;
//	}
	
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Product findproduct(@PathVariable Integer productId) {
        return productService.findByProductId(productId);
    }
	
//	@DeleteMapping("/product/delete/{id}")
//	public String productpage(@PathVariable Integer productId, Model m) {
//		productService.DeleteById(productId);
//		return "app.Product";
//	}
}
