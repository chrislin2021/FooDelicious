package foodelicious.cart.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import foodelicious.product.model.ProductService;

@RestController
public class CartController {

	@Resource
	private ProductService productService;

	@Resource
	private HttpSession session;

	@GetMapping("/shoppingCart")
	public String shoppingCart() {
		return "shoppingCart";
	}

	@SuppressWarnings("unchecked")
	@DeleteMapping("/shoppingCart/{id}")
	public void shoppingCart(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
		Map<String, Integer> cartMap = (Map<String, Integer>) session.getAttribute(id);

	}

}
