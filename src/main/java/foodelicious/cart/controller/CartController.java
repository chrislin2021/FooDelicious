package foodelicious.cart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import foodelicious.cart.model.CartBean;
import foodelicious.cart.service.CartService;

@RestController
@SessionAttributes("cart")
public class CartController {

	private CartService cartService;

	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}

	@GetMapping("/shoppingCart")
	public String shoppingCart() {
		return "shoppingCart";
	}

	@GetMapping("/shoppingCart/{id}")
	public List<CartBean> showCart(@PathVariable Long id, Model m) {
		var carts = (ArrayList<CartBean>) cartService.selectItem(id);
		m.addAttribute("carts", carts);
		return carts;
	}

	@PostMapping("/shoppingCart/add")
	public String addToCart(Model m, CartBean cart) {

		return null;
	}

	@DeleteMapping("/delete/{id}")
	@SuppressWarnings("unchecked")
	public String shoppingCart(@PathVariable String id, Model m) {
		var cart = (Map<String, Integer>) m.getAttribute("cart");
		cart.remove(id);
		m.addAttribute(id, cart);
		return "redirect:/cart/show";
	}

}
