package foodelicious.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import foodelicious.member.model.Member;
import foodelicious.member.service.MemberService;
import foodelicious.member.validator.MemberValidator;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	MemberValidator memberValidator;


	public MemberController(MemberService memberService, MemberValidator memberValidator) {
		super();
		this.memberService = memberService;
		this.memberValidator = memberValidator;
	}

	// 登入頁面
	@GetMapping("/LoginSystem")
	public String toMemberPage() {
		return "app.LoginSystem";
	}

	// GOOGLE登入
	@PostMapping("/googleLogin")
	public String googleLoginPage(Member member, @RequestParam String memberMail,HttpSession session) {

		if (memberService.findByMemberMail(member.getMemberMail()) != null) {
			session.setAttribute("memberId", member.getMemberId());
			return "app.loginSuccess";
		}
		member.setMemberDiscountId("none");
		member.setMemberCoin(10);
		member.setMember_status("customer");
		memberService.save(member);
		session.setAttribute("memberId", member.getMemberId());
		return "app.updatePage";
	}
	
}
