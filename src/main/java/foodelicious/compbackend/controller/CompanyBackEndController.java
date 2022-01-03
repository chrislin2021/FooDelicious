package foodelicious.compbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyBackEndController {

	@GetMapping(path = "/companyMain")
	public String companyMain() {

		return "app.CompanyMain";
	}

	@GetMapping(path = "/companyProduct")
	public String companyProduct() {

		return "app.CompanyProduct";
	}
	
	@GetMapping(path = "/companyOrder")
	public String companyOrder() {

		return "app.CompanyOrder";
	}
	
	@GetMapping(path ="/companyAddProduct")
	public String companyAddProduct() {
		return "app.CompanyAddProduct";
	}





}
