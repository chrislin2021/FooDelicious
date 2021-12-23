package foodelicious.compbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyBackEndController {

	@GetMapping(path = "/companyMain")
	public String main() {

		return "app.CompanyMain";
	}

	@GetMapping(path = "/companyProduct")
	public String product() {

		return "app.CompanyProduct";
	}




}
