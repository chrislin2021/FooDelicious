package foodelicious.orders.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodelicious.orders.model.OrdersBean;
import foodelicious.orders.model.OrdersService;

@RestController
@RequestMapping("/Order")
public class OrdersController {

	@Resource
	private OrdersService orderService;

	@GetMapping("/Temp")
	public OrdersBean temp(@PathVariable Long id) {
		return null;
	}

}