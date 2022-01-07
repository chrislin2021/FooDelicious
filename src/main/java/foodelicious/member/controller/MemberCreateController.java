package foodelicious.member.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import foodelicious.member.model.Member;
import foodelicious.member.service.MemberService;

@Controller
public class MemberCreateController {
	final static Logger log = LoggerFactory.getLogger(MemberCreateController.class);

	@Autowired
	MemberService memberService;

//		@Autowired
	public MemberCreateController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/listAllMembers")
	public String listAllMembers(Model model) {
		List<Member> members = memberService.findAll();
		System.out.println("members=" + members);
		
		model.addAttribute("membersForJSP",members);//屬性物件的識別字串，等同於servlet(HSR)的request.setAttribute
		model.addAttribute(members);//預設的識別字串
		return "listAllMembers";
	}

	// 註冊頁面
	@GetMapping("/RegisterPage")
	public String getMemberForm(Model model) {
		Member m = new Member();
		m.setMemberName("石七七");
		m.setPwd("${}13711");
		m.setMemberAddress("大安路1號");
		model.addAttribute("member", new Member());
		return "app.RegisterPage";
	}
	
	@PostMapping("/RegisterPage")//和網址相同
	public String saveMember(@Valid @ModelAttribute Member member, BindingResult result) {//此為表單綁定
		System.out.println("member= "+ member);
		
		Timestamp now = new Timestamp(System.currentTimeMillis());
		member.setRegister_date(now);
		memberService.save(member);
		return "redirect:/LoginSystem";
	}

//		===========================================
//				//註冊頁面 舊寫法
//				@GetMapping("/RegisterPage")
//				public String registerPage() {
//					System.out.println("=1111111111111=======");
//					return "app.RegisterPage";
//				}

//		@PostMapping("/RegisterPage")
//		public String registerPost(@RequestParam Map<String, String> formData, Model model, RedirectAttributes redirect) throws ParseException {
//			System.out.println("=================================");
//			Member mem = new Member();
//			mem.setMemberMail(formData.get("memberMail"));
//			mem.setPwd(formData.get("pwd"));
////			System.out.println(formData.get("memberMail"));
////			System.out.println(formData.get("pwd"));
//			mem.setMemberName(formData.get("memberName"));
//			mem.setMemberGender(formData.get("memberGender"));
//			mem.setMemberBirth(formData.get("memberBirth"));;
//			mem.setMemberPhone(formData.get("memberPhone"));
//			mem.setMemberAddress(formData.get("memberAddress"));
//			mem.setMember_status("customer");
//			mem.setMemberCoin(0);
//			mem.setMemberDiscountId("null");
//			if(memberService.save(mem)) {	
//				model.addAttribute("message","註冊成功");
//				System.out.println("=================================");
////				redirect.addFlashAttribute("message","註冊成功");
//			}else {
//				model.addAttribute("message","註冊失敗");
////				redirect.addFlashAttribute("message","註冊失敗");
//			}
//			System.out.println("==========" + mem);
//			return "app.LoginSystem";
//		}

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		// java.util.Date
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		CustomDateEditor ce = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(java.util.Date.class, ce);
		// java.sql.Date
		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat2.setLenient(false);
		CustomDateEditor ce2 = new CustomDateEditor(dateFormat2, true);
		binder.registerCustomEditor(java.sql.Date.class, ce2);
	}
}
