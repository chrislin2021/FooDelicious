package foodelicious.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class memberController {
	@RequestMapping("/LoginPage")
	public String loginInPage() {
		return "/member/LoginPage";
	}
}
