package foodelicious.orders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodelicious.cart.service.CartService;
import foodelicious.orders.model.OrdersBean;
import foodelicious.orders.service.OrdersService;

@RestController
@RequestMapping("/Order")
public class OrdersController {

	private OrdersService orderService;

	private CartService cartService;

	public OrdersController(OrdersService orderService, CartService cartService) {
		super();
		this.orderService = orderService;
		this.cartService = cartService;
	}

//	暫時寫的
	@GetMapping("/Temp")
	public OrdersBean temp(@PathVariable Long id) {
		return orderService.insertOrders(null);
	}

}
