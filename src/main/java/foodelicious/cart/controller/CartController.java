package foodelicious.cart.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import foodelicious.cart.model.CartBean;
import foodelicious.cart.service.CartService;
import foodelicious.member.model.Member;

@Controller
@SessionAttributes("cart")
public class CartController {

	private CartService cartService;

	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}

	@GetMapping("/index")
	public String shoppingCart(HttpSession session) {

		Member member = (Member) session.getAttribute("member");

		if (member == null) {
			return "app.LoginSystem";
		}

		Object cart = new HashMap<String, Integer>();

		return "app.ShoppingCart";

	}

//	@PostMapping("shoppingCart")
//	@SuppressWarnings("unchecked")
//	public String insertProductToCart(HttpSession session, Model m) {
//		var carts = (Map<String, Integer>) session.getAttribute("carts");
//		m.addAttribute("carts", carts);
//		return "app.ShoppingCart";
//	}

	@DeleteMapping("/delete/{id}")
	public String deleteItem(HttpSession session, Long productId) {

		Member member = (Member) session.getAttribute("member");

		if (member == null) {
			return "app.LoginSystem";
		}

		Member signInMember = (Member) member;

//		List<CartBean> carts = cartService.selectItem(signInMember.getMember_id());

//		for (CartBean cart : carts) {
//			if (cart.getProductId() == productId) {
//				cartService.deleteItem(cart.getCartId());
//				break;
//			}
//		}

		return null;

	}

//	@PostMapping("/insert")
//	public List<CartBean> insertProductToCart(HttpSession session, Model m) {
//
//		var carts = (ArrayList<CartBean>) cartService.selectItem(2L);
//		m.addAttribute("carts", carts);
//		return carts;
//	}

//
//	@PostMapping("/shoppingCart/add")
//	public String addToCart(Model m, CartBean cart) {
//
//		return null;
//	}
//

}
