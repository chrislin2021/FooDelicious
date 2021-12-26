package foodelicious.cart.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodelicious.cart.model.Cart;
import foodelicious.cart.model.CartService;
import foodelicious.member.model.Member;

@RestController
@RequestMapping("/shoppingCart")
public class CartController {

	@Resource
	private CartService cartService;

	@GetMapping("/index")
	public String shoppingCart() {
		return "shoppingCart";
	}

	@GetMapping("/{id}")
	public String shoppingCart(@PathVariable(name = "id") Member member_id, Model model) {
		List<Cart> cartList = cartService.findCartListByMember(member_id);
		model.addAttribute(cartList);
		return "/shoppingCart";
	}

}
