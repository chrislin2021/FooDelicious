package foodelicious.compbackend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CompanyBackEndController {

	@GetMapping(path = "/companyMain")
	public String companyMain() {

		return "app.CompanyMain";
	}

	@GetMapping(path = "/companyMain2")
	public String companyMain2() {

		return "app.CompanyMain2";
	}

	@GetMapping(path = "/companyProduct")
	public String companyProduct() {

		return "app.CompanyProduct";
	}

	@GetMapping(path = "/companyProduct2")
	public String companyProduct2() {

		return "app.CompanyProduct2";
	}

	@GetMapping(path = "/companyOrder")
	public String companyOrder() {

		return "app.CompanyOrder";
	}
	
	@GetMapping(path = "/companyProduct2/update")
	public String companyProductUpdate() {

		return "app.CompanyProductUpdate";
	}
	

	

	@GetMapping(path = "/logout")
	public String companyLogout(HttpSession session) {
		session.invalidate();
		return "app.home";
	}

	@GetMapping(path = "/test")
	public String test() {

		return "app.Test";
	}

}
