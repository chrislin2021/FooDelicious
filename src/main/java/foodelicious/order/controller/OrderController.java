package foodelicious.order.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import foodelicious.order.model.OrderService;

@RestController
public class OrderController {

	@Resource
	private OrderService orderService;

}
