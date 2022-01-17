package foodelicious.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String googleLoginPage(Member member, @RequestParam String memberMail, HttpSession session) {

		if (memberService.findByMemberMail(member.getMemberMail()) != null) {
			List<Member> EMid = memberService.findByMemberMailJpa(memberMail);
			for (Member members : EMid) {
				if (members.getMemberMail().equals(memberMail)) {
					session.setAttribute("userID", members.getMemberId());
					session.setAttribute("userName", members.getMemberName());
					break;
				}
			}
			return "app.home";
		}
		member.setMemberDiscountId("none");
		member.setMemberCoin(10);
		member.setMember_status("customer");
		memberService.save(member);
		session.setAttribute("memberId", member.getMemberId());
		return "redirect:/";
	}
	
	@ResponseBody
	@GetMapping("/useIdFindEmail/{id}")
	public String usdIdFindEmail(@PathVariable(value = "id") Long id) {	
		System.out.println(id);
		System.out.println(memberService.useIdFindEmail(id));
		return memberService.useIdFindEmail(id);
	}
}
