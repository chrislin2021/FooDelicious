package foodelicious.custService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodelicious.custService.model.CustomerService;
import foodelicious.custService.model.CustomerServiceService;

@Controller
@RequestMapping("/custService")
public class CustServiceController {
	
	private final CustomerServiceService customerService;
	
	@Autowired
	public CustServiceController(CustomerServiceService customerService) {
		super();
		this.customerService = customerService;
	}
	@GetMapping
	public String getCustService() {
		return "app.CustService";
	} 
}