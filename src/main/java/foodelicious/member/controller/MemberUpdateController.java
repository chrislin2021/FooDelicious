package foodelicious.member.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import foodelicious.backend.memberpage.model.BkMember;
import foodelicious.member.model.Member;
import foodelicious.member.service.MemberService;
import foodelicious.product.model.Product;

@Controller
public class MemberUpdateController {
	
	MemberService memberService;
	
	@Autowired
	public MemberUpdateController(MemberService memberService) {
		this.memberService = memberService;
	}	
	
	@GetMapping("/updatePage")//和網址相同
	public String sendMemberDataToModified(Model model, 
			@RequestParam(value = ("MemberId"),required=true) Long memberId) {//spring會讀三種： 請求參數、路徑變數、表單綁定
		Member member= memberService.findByMemberId(memberId);
		model.addAttribute("member", member);
		model.addAttribute("memberId", memberId);
		
		return "app.updatePage";
	}
	
	@PutMapping("/members/{memberId}")//{}為路徑變數
	public String updateMemberData(@ModelAttribute("member") Member member, BindingResult result, Model model, 
			@PathVariable Long memberId) {//spring會讀三種： 請求參數、路徑變數、表單綁定
		
		memberService.update(member);
		return "redirect:/members";
	}
	
	
	
	
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
