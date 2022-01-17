package foodelicious.orders.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import foodelicious.cart.model.CartBean;
import foodelicious.cart.service.CartService;
import foodelicious.orders.model.OrdersBean;
import foodelicious.orders.model.OrdersDetailBean;
import foodelicious.orders.service.OrdersDetailService;
import foodelicious.orders.service.OrdersService;

@Controller
public class OrdersController {

	private HttpSession session;

	private CartService cartService;
	
	private OrdersBean ordersBean;

	private OrdersService ordersService;

	private OrdersDetailService ordersDetailService;

	public OrdersController(HttpSession session, CartService cartService, OrdersService ordersService,
			OrdersDetailService ordersDetailService) {
		super();
		this.session = session;
		this.cartService = cartService;
		this.ordersService = ordersService;
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

		OrdersDetailBean ordersDetailBean = new OrdersDetailBean();

		ordersDetailBean.setOrdersId(ordersBean.getOrdersId());
		ordersDetailBean.setProductDetail(ordersDetail);

		ordersDetailService.insertOrderDetail(ordersDetailBean);

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		for (CartBean cart : carts) {
			cartService.deleteItem(cart.getCartId());
			session.removeAttribute("discountContent");
		}

	}

	@GetMapping("/ordersEnd")
	public String ordersEnd() {
		return "app.OrdersEnd";
	}

}
