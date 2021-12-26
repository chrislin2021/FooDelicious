package foodelicious.order.controller;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodelicious.order.model.Order;
import foodelicious.order.model.OrderService;

@RestController
@RequestMapping("/Order")
public class OrderController {

	@Resource
	private OrderService orderService;

	@GetMapping("/Order/{id}")
	public Optional<Order> getOrderById(@PathVariable Long id) {
		return orderService.findByOrderId(id);
	}

}
