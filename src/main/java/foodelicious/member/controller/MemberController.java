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
	
}