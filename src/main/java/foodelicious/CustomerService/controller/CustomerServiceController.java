package foodelicious.CustomerService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import foodelicious.CustomerService.service.CustomerService_Service;

@Controller
@RequestMapping("/customerService")
public class CustomerServiceController {

	private final CustomerService_Service customerService;

	@Autowired
	public CustomerServiceController(CustomerService_Service customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping
	public String getCustomerService() {
		return "app.CustomerService";
	}
}