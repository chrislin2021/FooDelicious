package foodelicious.cart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodelicious.cart.model.Cart;
import foodelicious.cart.model.CartService;
import foodelicious.product.model.Product;
import foodelicious.product.model.ProductService;
import freemarker.template.utility.CollectionUtils;

@RestController
public class CartController {

	@Resource
	private CartService cartService;

	@Resource
	private ProductService productService;

	@GetMapping("/shoppingCart")
	public String shoppingCart() {
		return "shoppingCart";
	}

	@GetMapping("/shoppingCart/show")
	public String showCart(Model model) {
		ArrayList<Cart> carts = (ArrayList<Cart>) cartService.findAll();
		model.addAttribute("carts", carts);
		return "showCart";
	}

//	@PostMapping("/shoppingCart/add")
//	public String addToCart(Model m, Cart cart) {
//		Product product = productService.
//		return null;
//
//	}

//	@DeleteMapping("/shoppingCart/{id}")
//	public String shoppingCart(@PathVariable Long id, Model m) {
//		cartService.deleteById(id);
//		return "redirect:/cart/show";
//	}

}
