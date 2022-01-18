package foodelicious.orders.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import foodelicious.cart.model.CartBean;
import foodelicious.cart.service.CartService;
import foodelicious.discount.service.DiscountService;
import foodelicious.member.model.Member;
import foodelicious.orders.model.OrdersBean;
import foodelicious.orders.model.OrdersDetailBean;
import foodelicious.orders.service.OrdersDetailService;
import foodelicious.orders.service.OrdersService;
import foodelicious.product.model.ProductService;

@Controller
public class OrdersController {

	private HttpSession session;

	private CartService cartService;

	private OrdersBean ordersBean;

	private OrdersService ordersService;

	private ProductService productService;

	private DiscountService discountService;

	private OrdersDetailService ordersDetailService;

	public OrdersController(HttpSession session, CartService cartService, OrdersBean ordersBean,
			OrdersService ordersService, ProductService productService, DiscountService discountService,
			OrdersDetailService ordersDetailService) {
		super();
		this.session = session;
		this.cartService = cartService;
		this.ordersBean = ordersBean;
		this.ordersService = ordersService;
		this.productService = productService;
		this.discountService = discountService;
		this.ordersDetailService = ordersDetailService;
	}

	@ResponseBody
	@PostMapping("/orders/insert")
	public void orders(@RequestBody OrdersBean orders) {

		OrdersBean ordersBean = new OrdersBean();

		Date date = new Date();

		Timestamp timeStamp = new Timestamp(date.getTime());

		ordersBean.setMemberId((Long) session.getAttribute("userID"));
		ordersBean.setOrderDate(timeStamp);
		ordersBean.setOrdersName(orders.getOrdersName());
		ordersBean.setOrdersPhone(orders.getOrdersPhone());
		ordersBean.setOrdersAddress(orders.getOrdersAddress());
		ordersBean.setOrdersState("訂單處理中");
		ordersBean.setOrdersTotal((Integer) session.getAttribute("priceTotal"));

		ordersService.insertOrders(ordersBean);
		this.ordersBean = ordersBean;
	}

	@ResponseBody
	@PostMapping("/ordersDetail/insert")
	public void ordersDetail(@RequestBody String ordersDetail) {

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		for (CartBean cart : carts) {
			OrdersDetailBean ordersDetailBean = new OrdersDetailBean();
			ordersDetailBean.setOrdersId(ordersBean.getOrdersId());
			ordersDetailBean.setProduct_id(cart.getProductId());
			ordersDetailBean.setQuantity(cart.getQuantity());
			ordersDetailService.insertOrderDetail(ordersDetailBean);
			cartService.deleteItem(cart.getCartId());
			session.removeAttribute("discountContent");
		}

	}

	@GetMapping("/ordersEnd")
	public String ordersEnd() {
		return "app.OrdersEnd";
	}

	@GetMapping("/viewOrders")
	public String viewOrders() {
		List<OrdersBean> orders = ordersService.selectOrders((Long) session.getAttribute("userID"));

		session.setAttribute("orders", orders);

		return "app.ViewOrders";
	}

	@GetMapping("/toOrderDetailPage/{ordersId}")
	public String toOrdersDetailPage(@PathVariable Long ordersId) {
		List<OrdersDetailBean> details = ordersDetailService.selectOrdersDetail(ordersId);

		session.setAttribute("details", details);

		return "app.ViewOrdersDetail";
	}

}
