package foodelicious.cart.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import foodelicious.cart.model.CartBean;
import foodelicious.cart.service.CartService;
import foodelicious.member.model.Member;
import foodelicious.product.model.Product;

@Controller
public class CartController {

	@Resource
	private HttpSession session;

	private CartService cartService;

	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}

//	檢查使用者有沒有登入
	public Boolean checkLogin() {
		Object member = session.getAttribute("userID");

		return member != null;
	}

//	購物車主頁面
	@GetMapping("/shoppingCart")
	public String shoppingCart(Model m) {

//		沒登入就給我滾去登入
		if (!checkLogin()) {
			return "app.LoginSystem";
		}

//		從Session抓到登入的使用者後，把存在持久層的資料都拉出來
		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		m.addAttribute("carts", carts);

		return "app.ShoppingCart";
	}

	@ResponseBody
	@PostMapping("/shoppingCart/insertProduct")
	public String insertItem(Model m, Long productId) {

		Boolean exist = false;

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		for (CartBean cart : carts) {
			if (productId == cart.getProductId()) {
//				暫時增加一個商品，因為商品還沒做到這
				Integer quantity = cart.getQuantity() + 1;
				Product product = cart.getProduct();
				if (quantity > product.getProductStock()) {

				}
//				垃圾JPA更新如果不給他全部值，會變NULL
				cart.setCartId(cart.getCartId());
				cart.setMemberId(cart.getMemberId());
				cart.setProductId(cart.getProductId());
				cart.setQuantity(quantity);

				cartService.insertAndUpdateItem(cart);
				exist = true;
				break;
			}
		}

		return "app.ShoppingCart";
	}

	@GetMapping("/shoppingCart/{id}")
	public String deleteItem(@PathVariable(name = "id") Long productId, Model m) {

		cartService.deleteItem(productId);

		return "redirect:/shoppingCart";

	}

	@ResponseBody
	@PutMapping("/shoppingCart/")
	public List<CartBean> updateItem(Model m) {

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		m.addAttribute("carts", carts);
		return carts;
	}

}
