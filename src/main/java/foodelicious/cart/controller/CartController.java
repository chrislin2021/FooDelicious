package foodelicious.cart.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import foodelicious.cart.model.CartService;

@RestController
public class CartController {

	@Resource
	private CartService cartService;
}
