package foodelicious.cart.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import foodelicious.cart.model.CartService;

@RestController
@SessionAttributes("cart")
public class CartController {

	@Resource
	private CartService cartService;
}
