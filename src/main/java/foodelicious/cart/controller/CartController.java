package foodelicious.cart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	public String showCart(Model m) {

		if (!checkLogin()) {
			return "app.LoginSystem";
		}

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		Integer priceTotal = 0;

		for (CartBean cart : carts) {
			if (!CollectionUtils.isEmpty(carts)) {
				priceTotal += cart.getProduct().getProductPrice() * cart.getQuantity();
			}
		}

		m.addAttribute("carts", carts);
		m.addAttribute("priceTotal", priceTotal);

		return "app.ShoppingCart";
	}

//	使用者新增商品至購物車
	@ResponseBody
	@PostMapping("/shoppingCart/insertProduct")
	public String insertItem(Model m, Long productId) {

//		判斷購物車是否有重複商品
		Boolean judge = false;

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		for (CartBean cart : carts) {
			if (productId == cart.getProductId()) {
//				暫時增加一個商品，因為商品還沒做到這
				Integer sum = cart.getQuantity() + 1;
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

				judge = true;
				break;
			}
		}

//		暫時先做到這商品還沒新增
		if (judge != true) {
			CartBean cartBean = new CartBean();
			cartBean.setMemberId((Long) session.getAttribute("userID"));
			cartBean.setProductId(null);
			cartBean.setQuantity(null);
		}

		return "{\"ans\":\"" + "此項商品數量 " + null + " 個已加入購物車" + "\"}";
	}

//	刪除商品
	@DeleteMapping("/shoppingCart/{productId}")
	public String deleteItem(@RequestParam Long productId, Model m) {

//		沒登入就給我滾去登入
		if (!checkLogin()) {
			return "app.LoginSystem";
		}

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		for (CartBean cart : carts) {
			if (cart.getProductId() == productId) {
				cartService.deleteItem(cart.getCartId());
				break;
			}
		}

		return "redirect:/shoppingCart";

	}

	@ResponseBody
	@PutMapping("/shoppingCart/")
	public List<CartBean> updateItem(Model m) {

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		m.addAttribute("carts", carts);
		return carts;
	}

//	檢查使用者有沒有登入
	public Boolean checkLogin() {
		Object member = session.getAttribute("userID");

		return member != null;
	}

////	購物車總金額
//	public void totalAmount() {
//
//		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));
//
//		Integer totalAmount = 0;
//
//		for (CartBean cart : carts) {
//			Product product = cart.getProduct();
//			totalAmount += product.getProductPrice() * cart.getQuantity();
//		}
//
//		session.setAttribute("totalAmount", totalAmount);
//
////		return totalAmount;
//	}

}
