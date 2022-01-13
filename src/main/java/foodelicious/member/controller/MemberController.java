package foodelicious.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import foodelicious.member.model.Member;
import foodelicious.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

	// 登入頁面
	@GetMapping("/LoginSystem")
	public String toMemberPage() {
		return "app.LoginSystem";
	}

	// GOOGLE登入
	@PostMapping("/googleLogin")
	public String googleLoginPage(HttpServletRequest request, Member member) {

		request.getRemoteAddr();
		memberService.save(member);
		System.out.println(member.getMemberMail());
		return "app.loginSuccess";
	}

}