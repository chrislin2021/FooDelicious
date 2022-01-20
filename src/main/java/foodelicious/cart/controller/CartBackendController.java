package foodelicious.cart.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import foodelicious.cart.model.CartBean;
import foodelicious.cart.service.CartService;

@RestController
public class CartBackendController {

	private CartService cartService;

	public CartBackendController(CartService cartService) {
		super();
		this.cartService = cartService;
	}

	@GetMapping("/report/cart")
	public List<CartBean> findAll() {
		List<CartBean> carts = cartService.selectAll();
		return carts;
	}

}
