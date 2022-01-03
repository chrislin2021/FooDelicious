package foodelicious.member.controller;

import java.text.ParseException;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import foodelicious.member.model.Member;
import foodelicious.member.service.MemberService;

@Controller
public class MemberCreateController {
		
		@Autowired
		MemberService memberService;
		
		@Autowired
		public MemberCreateController(MemberService memberService) {
			this.memberService = memberService;
		}	
		
		//註冊頁面
		@GetMapping("/RegisterPage")
		public String registerPage() {
			System.out.println("=1111111111111=======");
			return "app.RegisterPage";
		}
		
		@PostMapping("/RegisterPage")
		public String registerPost(@RequestParam Map<String, String> formData, Model model, RedirectAttributes redirect) throws ParseException {
			System.out.println("=================================");
			Member mem = new Member();
			mem.setMemberMail(formData.get("memberMail"));
			mem.setPwd(formData.get("pwd"));
//			System.out.println(formData.get("memberMail"));
//			System.out.println(formData.get("pwd"));
			mem.setMemberName(formData.get("memberName"));
			mem.setMemberGender(formData.get("memberGender"));
			mem.setMemberBirth(formData.get("memberBirth"));;
			mem.setMemberPhone(formData.get("memberPhone"));
			mem.setMemberAddress(formData.get("memberAddress"));
			mem.setMember_status("customer");
			mem.setMemberCoin(0);
			mem.setMemberDiscountId("null");
			if(memberService.save(mem)) {	
				model.addAttribute("message","註冊成功");
				System.out.println("=================================");
//				redirect.addFlashAttribute("message","註冊成功");
			}else {
				model.addAttribute("message","註冊失敗");
//				redirect.addFlashAttribute("message","註冊失敗");
			}
			System.out.println("==========" + mem);
			return "app.LoginSystem";
		}
}
