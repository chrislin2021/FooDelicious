package foodelicious.member.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MemberController {
	//登入頁面
	@GetMapping("/LoginSystem")
	public String toMemberPage() {
		return "app.LoginSystem";
	}
	


//	// 轉換頁面用 Login->register
//	@GetMapping("/Regi")
//	public String goRegistergepage() {
//		return "app.RegisterPage";
//	}


	
}