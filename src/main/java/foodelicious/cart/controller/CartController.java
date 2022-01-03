package foodelicious.cart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import foodelicious.cart.model.CartBean;
import foodelicious.cart.service.CartService;
import foodelicious.member.model.Member;

@Controller
public class CartController {

	private CartService cartService;

	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}

	@GetMapping("/shoppingCart")
	public String shoppingCart() {
		return "app.ShoppingCart";
	}

	@PostMapping("/shoppingCart/insertProduct")
	public String insertProductIntoCart(Model m) {

		return "app.ShoppingCart";
	}

	@ResponseBody
	@DeleteMapping("/shoppingCart/{id}")
	public String deleteItem(Long productId, Model m) {

		Member member = (Member) m.getAttribute("cart");

		List<CartBean> carts = cartService.selectItem(member.getMember_id());

		for (CartBean cart : carts) {
			if (cart.getProductId() == productId) {
				cartService.deleteItem(cart.getCartId());
				break;
			}
		}

		return "app.ShoppingCart";
	}

	@GetMapping("/insert")
	@ResponseBody	
	public List<CartBean> insertProductToCart(HttpSession session, Model m) {
		List<CartBean> carts = (List<CartBean>) cartService.selectItem(2L);
		m.addAttribute("carts", carts);
		return carts;
	}

//
//	@PostMapping("/shoppingCart/add")
//	public String addToCart(Model m, CartBean cart) {
//
//		return null;
//	}
//

}
