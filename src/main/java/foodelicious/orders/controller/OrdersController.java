package foodelicious.orders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import foodelicious.cart.service.CartService;
import foodelicious.orders.service.OrdersDetailService;
import foodelicious.orders.service.OrdersService;

@RestController
public class OrdersController {

	private OrdersService orderService;

	private CartService cartService;

	private OrdersDetailService ordersDetailService;

	public OrdersController(OrdersService orderService, CartService cartService,
			OrdersDetailService ordersDetailService) {
		super();
		this.orderService = orderService;
		this.cartService = cartService;
		this.ordersDetailService = ordersDetailService;
	}

//	暫時寫的
	@GetMapping("/Temp")
	public void temp() {
		orderService.selectAll();
		cartService.selectItem(null);
		ordersDetailService.insertOrderDetail(null);
	}

}
