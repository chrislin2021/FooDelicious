package foodelicious.orders.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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

	private OrdersDetailBean ordersDetailBean;

	private OrdersService ordersService;

	private OrdersDetailService ordersDetailService;

	public OrdersController(HttpSession session, CartService cartService, OrdersBean ordersBean,
			OrdersDetailBean ordersDetailBean, OrdersService ordersService, OrdersDetailService ordersDetailService) {
		super();
		this.session = session;
		this.cartService = cartService;
		this.ordersBean = ordersBean;
		this.ordersDetailBean = ordersDetailBean;
		this.ordersService = ordersService;
		this.ordersDetailService = ordersDetailService;
	}

	@ResponseBody
	@PostMapping("/orders/insert")
	public String orders(@RequestBody String orders) {

		JSONObject obj = JSON.parseObject(orders);
		Object name = obj.get("ordersName");
		Object phone = obj.get("ordersPhone");
		Object address = obj.get("ordersAddress");
		String mName = (String) name;
		String mPhone = (String) phone;
		String mAddress = (String) address;

		Date date = new Date();

		Timestamp timeStamp = new Timestamp(date.getTime());

		ordersBean.setMemberId((Long) session.getAttribute("userID"));

		ordersBean.setOrderDate(timeStamp);
		ordersBean.setOrdersName(mName);
		ordersBean.setOrdersPhone(mPhone);
		ordersBean.setOrdersAddress(mAddress);
		ordersBean.setOrdersState("訂單處理中");
		ordersBean.setOrdersTotal((Integer) session.getAttribute("priceTotal"));
		OrdersBean newOrders = ordersService.insertOrders(ordersBean);

		Long ordersId = newOrders.getOrdersId();

		Set<OrdersDetailBean> ordersSet = newOrders.getOrderDetail();

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		for (CartBean cart : carts) {
			ordersDetailBean.setOrderId(ordersId);
			ordersDetailBean.setMemberId(cart.getMemberId());
			ordersDetailBean.setProductId(cart.getProductId());
			ordersDetailBean.setQuantity(cart.getQuantity());
			ordersDetailService.insertOrderDetail(ordersDetailBean);
			ordersSet.add(ordersDetailBean);
		}

		newOrders.setOrderDetail(ordersSet);

		for (CartBean cart : carts) {
			cartService.deleteItem(cart.getCartId());
		}

		return "app.OrdersEnd";
	}

}
