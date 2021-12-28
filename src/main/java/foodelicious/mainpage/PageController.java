package foodelicious.mainpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

	// 首頁
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage() {
		return "app.home";
	}

	@GetMapping("/LoginSystem")
	public String toMemberPage() {
		return "app.LoginSystem";
	}
	
	@GetMapping("/RegisterPage")
	public String registerPage() {
		return "app.RegisterPage";
	}

	// 轉換頁面用 Login->register
	@GetMapping("/goregister")
	public String goRegistergepage() {
		return "app.RegisterPage";
	}

	@GetMapping("/postArticle")
	public String goPostArticle() {
		return "app.PostArticle";
	}
	
	@GetMapping("/goShareArea")
	public String goShareArea() {
		return "app.ShareArea";
	}
	
	@GetMapping("/Product")
	public String productpage() {
		return "app.Product";
	}
	
	@GetMapping("/ProductDetail")
	public String productDetailpage() {
		return "app.ProductDetail";
	}
}
