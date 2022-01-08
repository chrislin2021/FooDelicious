package foodelicious.cart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import foodelicious.cart.model.CartBean;
import foodelicious.cart.service.CartService;
import foodelicious.product.model.Product;

@Controller
public class CartController {

	private HttpSession session;

	private CartService cartService;

	public CartController(HttpSession session, CartService cartService) {
		super();
		this.session = session;
		this.cartService = cartService;
	}

	@GetMapping("/shoppingCart")
	public String shoppingCart(Model m) {

		if (session.getAttribute("userID") != null) {
			List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));
			m.addAttribute("carts", carts);
			m.addAttribute("priceTotal", priceTotal());
			return "app.ShoppingCart";
		} else {
			return "app.LoginSystem";
		}
	}

	@ResponseBody
	@GetMapping("/showCart")
	public List<CartBean> showCart() {
		List<CartBean> origin = cartService.selectItem((Long) session.getAttribute("userID"));
		return origin;
	}

	@ResponseBody
	@PostMapping("/shoppingCart/insert")
	public String insertItem(@RequestBody Long productId, @RequestBody Integer quantity) {

//		判斷購物車是否有重複商品
		Boolean same = false;

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		for (CartBean cart : carts) {
			if (cart.getProductId() == productId) {
//				暫時增加一個商品，因為商品還沒做到這
				Integer sum = cart.getQuantity() + quantity;
				Product product = cart.getProduct();
				if (sum > product.getProductStock()) {
					return "{\"ans\":\"已經到達庫存最大數量了\\n (目前庫存共有 " + product.getProductStock() + " 件)" + "\"}";
				}

//				垃圾JPA更新如果不給他全部值，更新外的會變NULL
				cart.setCartId(cart.getCartId());
				cart.setMemberId(cart.getMemberId());
				cart.setProductId(cart.getProductId());
				cart.setQuantity(sum);

				cartService.insertAndUpdateItem(cart);

				same = true;
				break;
			}
		}

//		暫時先做到這商品還沒新增
		if (same != true) {
			CartBean cartBean = new CartBean();
			cartBean.setMemberId((Long) session.getAttribute("userID"));
			cartBean.setProductId(productId);
			cartBean.setQuantity(quantity);
		}

		return "{\"ans\":\"" + "此項商品數量 " + quantity + " 個已加入購物車" + "\"}";
	}

	@ResponseBody
	@DeleteMapping("/shoppingCart/{id}")
	public String deleteItem(@PathVariable(name = "id") Long productId, Model m) {

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		for (CartBean cart : carts) {
			if (cart.getProductId() == productId) {
				cartService.deleteItem(cart.getCartId());
				break;
			}
		}
		return "{\"ans\":\"已成功刪除編號 " + productId + "號 商品\"}";
	}

	@ResponseBody
	@PutMapping("/shoppingCart/update")
	public Integer updateItem(@RequestBody Long productId, @RequestBody Integer quantity) {

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		for (CartBean cart : carts) {
			if (cart.getProductId() == productId) {
				cart.setQuantity(quantity);
				cartService.insertAndUpdateItem(cart);
				break;
			}
		}

		Integer priceTotal = priceTotal();

		return priceTotal();
	}

	public Integer priceTotal() {
		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));
		Integer priceTotal = 0;
		for (CartBean cart : carts) {
			Product product = cart.getProduct();
			priceTotal += product.getProductPrice() * cart.getQuantity();
		}
		return priceTotal;
	}

}
