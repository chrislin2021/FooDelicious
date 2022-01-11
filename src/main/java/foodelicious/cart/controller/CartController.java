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
import foodelicious.discount.model.DiscountBean;
import foodelicious.discount.service.DiscountService;
import foodelicious.product.model.Product;

@Controller
public class CartController {

	private HttpSession session;

	private CartService cartService;

	private DiscountService discountService;

	public CartController(HttpSession session, CartService cartService, DiscountService discountService) {
		super();
		this.session = session;
		this.cartService = cartService;
		this.discountService = discountService;
	}

	@GetMapping("/shoppingCart")
	public String shoppingCart(Model m) {

		if (session.getAttribute("userID") != null) {
			List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));
			m.addAttribute("carts", carts);
			m.addAttribute("coin", getGoldCoin());
			m.addAttribute("priceTotal", originTotal());
			return "app.ShoppingCart";
		} else {
			return "app.LoginSystem";
		}
	}

	@ResponseBody
	@PostMapping("/shoppingCart/insert")
	public String insertItem(@RequestBody Long productId, @RequestBody Integer quantity) {

		if (session.getAttribute("userID") == null) {
			return "{\"ans\":\"請先登入會員!!\"}";
		}

//		判斷購物車是否有重複商品
		Boolean same = false;

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		for (CartBean cart : carts) {
			if (cart.getProductId() == productId) {
				Integer sum = cart.getQuantity() + quantity;
				Product product = cart.getProduct();
				if (sum > product.getProductStock()) {
					return "{\"ans\":\"已經到達庫存最大數量了\\n (目前庫存共有 " + product.getProductStock() + " 件)" + "\"}";
				}

				cart.setCartId(cart.getCartId());
				cart.setMemberId(cart.getMemberId());
				cart.setProductId(cart.getProductId());
				cart.setQuantity(sum);

				cartService.insertAndUpdateItem(cart);

				same = true;
				break;
			}
		}

		if (same != true) {
			CartBean cartBean = new CartBean();
			cartBean.setMemberId((Long) session.getAttribute("userID"));
			cartBean.setProductId(productId);
			cartBean.setQuantity(quantity);
		}

		return "{\"ans\":\"" + "此項商品數量 " + quantity + " 個已加入購物車" + "\"}";
	}

	@ResponseBody
	@DeleteMapping("/shoppingCart/{productId}")
	public void deleteItem(@PathVariable Long productId, Model m) {

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		for (CartBean cart : carts) {
			if (cart.getProductId() == productId) {
				cartService.deleteItem(cart.getCartId());
				break;
			}
		}
	}

	@ResponseBody
	@PutMapping("/shoppingCart/{pid}/{pqty}")
	public void updateItem(@PathVariable String pid, @PathVariable String pqty, Model m) {

		Long id = Long.parseLong(pid);

		Integer qty = Integer.parseInt(pqty);

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		for (CartBean cart : carts) {
			if (cart.getProductId() == id) {
				cart.setQuantity(cart.getQuantity() + qty);
				if (cart.getQuantity() > cart.getProduct().getProductStock()) {
					cart.setQuantity(cart.getProduct().getProductStock());
				} else if (cart.getQuantity() > 0) {
					cartService.insertAndUpdateItem(cart);
				} else {
					cart.setQuantity(1);
				}
				break;
			}
		}
	}

	@ResponseBody
	@GetMapping("/shoppingCart/show")
	public List<CartBean> selectItem(Model m) {

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		return carts;
	}

	@ResponseBody
	@GetMapping("/shoppingCart/discountTotal/{discountName}/{coin}")
	public Integer discountTotal(@PathVariable(required = false) String discountName,
			@PathVariable(required = false) String coin) {

		List<DiscountBean> discounts = discountService.selectItem((Long) session.getAttribute("userID"));

		Integer currentCoin = Integer.parseInt(coin);

		Integer originTotal = originTotal();

		if (discountName != null) {
			for (DiscountBean discount : discounts) {
				if (discount.getDiscountName().equals(discountName)) {
					originTotal -= discount.getDiscountContent();
					break;
				}
			}
		}

		if (currentCoin != 0) {
			originTotal -= currentCoin;
		}

		if (originTotal < 0) {
			originTotal = 0;
		}

		session.setAttribute("priceTotal", originTotal);

		return originTotal;
	}

//	顯示初始金額
	public Integer originTotal() {

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		Integer originTotal = 0;

		for (CartBean cart : carts) {
			Product product = cart.getProduct();
			originTotal += product.getProductPrice() * cart.getQuantity();
		}

		return originTotal;
	}

	public Integer getGoldCoin() {
		Integer coin = 0;
		if (session.getAttribute("userID") != null) {
			List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));
			for (CartBean cart : carts) {
				coin = cart.getMember().getMemberCoin();
			}
		}
		return coin;
	}

}
