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

import foodelicious.cart.model.CartBean;
import foodelicious.cart.model.CartService;
import foodelicious.member.model.Member;
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

//	@GetMapping("/shoppingCart/{id}")
//	public String showCart(@PathVariable Long id, Model model) {
//		System.out.println(id + "[==========================================");
//		Member member = new Member();
//		member.setMember_id(id);
//		ArrayList<CartBean> carts = (ArrayList<CartBean>) cartService.findByMember(member);
//		model.addAttribute("carts", carts);
//		for (CartBean cart : carts) {
//			System.out.println(cart.getCart_id());
//			System.out.println(cart.getMember().getUserName());
//			System.out.println(cart.getProduct().getProduct_name());
//			System.out.println(cart.getQuantity());
//			System.out.println(cart.getUnitPrice());
//			System.out.println(cart.getTotalPrice());
//		}
//		return "app.ShoppingCart";
//	}

//	@PostMapping("/shoppingCart/add")
//	public String addToCart(Model m, Cart cart) {
//		Product product = productService
//		return null;
//
//	}

//	@DeleteMapping("/shoppingCart/{id}")
//	public String shoppingCart(@PathVariable Integer id, Model m) {
//		cartService.deleteById(id);
//		return "redirect:/cart/show";
//	}

}
