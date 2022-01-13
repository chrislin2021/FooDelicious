package foodelicious.cashflow.restcontroller;


import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import foodelicious.cashflow.model.CashflowAddressBean;
import foodelicious.cashflow.service.CashflowAddressService;
import foodelicious.mail.service.MailService;
import foodelicious.member.model.Member;
import foodelicious.member.repository.MemberRepositoryImpl;
import foodelicious.member.service.MemberService;
import foodelicious.member.validator.MemberValidator;


@RestController
@Transactional
public class CashFlowAddressRestController {
	
	
	@PersistenceContext
	EntityManager em;
	
//	private HttpSession session;
	private CashflowAddressService cashflowAddressService;
	private MailService mailService;
//	private Member member;
	private MemberRepositoryImpl memberRepositoryImpl;

	
	public CashFlowAddressRestController(CashflowAddressService cashflowAddressService,EntityManager em, HttpSession session, 
			Member member,MemberRepositoryImpl memberRepositoryImpl, MailService mailService,MemberService memberService,MemberValidator memberValidator) {
//		super();
//		this.session = session;
		this.cashflowAddressService = cashflowAddressService;
		this.mailService = mailService;
//		this.member = member;
		this.memberRepositoryImpl = memberRepositoryImpl;
	}

	
	@ResponseBody
	@GetMapping(path = "/member/CashflowAddress")
	public HashMap<Object, Object> CashFlowAddressTable(Model m, Long productId, Long memberId, HttpSession session) {
		HashMap<Object, Object> table = new HashMap<Object, Object>();
				
		CashflowAddressBean cfab = cashflowAddressService.getCashflowAddressBeanByMember((Long)session.getAttribute("userID"));
		Member members = memberRepositoryImpl.findByMemberId(memberId);

			
		table.put("memberMail", members.getMemberMail());
		table.put("memberId", members.getMemberName());
		table.put("memberAddress", members.getMemberAddress());
		table.put("CommonAddress", cfab.getCommonAddress());
		em.close();
		mailService.prepareAndSend("請輸入信箱@gmail.com", "title", "Sample mail subject");

		return table;
	}
}	


//	
//	@ResponseBody
//	@GetMapping(path = "/shoppingCart/Address")	
//	public String insertAddress(@RequestBody Long addressId, @RequestBody String commonAddress) {
//		
//		if (HttpSession.getAttribute("userID") == null) {
//			return "{\"ans\":\"請先登入會員!!\"}";
//		}		
//		List<CashflowAddressBean> CfB = cashflowAddressService.selectAddress((Long) session.getAttribute("addressId"));
//		
//		for (CashflowAddressBean CfBs : CfB) {
//			if(CfBs.getAddressId() == addressId) {
//				Long address = CfBs.getAddressId();
//			}
//			CfBs.setAddressId(CfBs.getAddressId());
//			CfBs.setMemberAddress(CfBs.getMemberAddress());
//			CfBs.setCommonAddress(CfBs.getCommonAddress());
//			
//			cashflowAddressService.insertAndUpdateAddress(CfBs);
//				
//		}
//		return commonAddress;
//	}

//	public Long findId(Member users) {
//		TypedQuery<Member> query = null;
//		String hqlstr = "FROM member_data2 WHERE member_address =:user AND pwd = :pwd";
//		query = em.createQuery(hqlstr, Member.class);
//		query.setParameter("user", users.getMemberAddress());
//		query.setParameter("pwd", users.getPwd());
//
//		Member account =  query.getSingleResult();
//		mailService.prepareAndSend("請輸入信箱@gmail.com", "title", "Sample mail subject");
//		em.close();
//		return account.getMemberId();
//	}
//	
//	public List<CashflowAddressBean> findById(HttpSession session){
//		Long id = (Long)
//				session.getAttribute("userID");
//		List<CashflowAddressBean> cashflowAB = cashAddressDao.findById(id);
//		return cashflowAB;
//	}	
//	@GetMapping("/CashFlowAddress2/updatePage") // 和網址相同
//	public String sendMemberDataToModified(Model model,
//			@RequestParam(value = ("MemberId"), required = true) Long memberId) {// spring會讀三種： 請求參數、路徑變數、表單綁定
//		Member member = memberService.findByMemberId(memberId);
//		model.addAttribute("member", member);
//		model.addAttribute("memberId", memberId);
//
//		return "app.updatePage";
//	}
//
//	@ResponseBody
//	@GetMapping("/CashFlowAddress2")
//	public Map<String, Object> totalAddress() {
//		Map<String, Object> data = new HashMap<>();
//		data.put("session", session.getAttribute("userID"));
//		return data;
//	}
//	@PostMapping("/CashFlowAddress2/members/{memberId}") // {}為路徑變數
//	public String updateMemberData(
//			@Valid @ModelAttribute Member member, 
//			BindingResult result, 
//			@PathVariable Long memberId,
//			Model model,
//			RedirectAttributes ra) {
//		System.out.println("pmember=" + member);
//
//		List<ObjectError> errors = result.getAllErrors();
//		for (ObjectError oe : errors) {
//			System.out.println(oe.getCode() + "," + oe.getDefaultMessage() + "," + oe.getObjectName());
//		}
//
//		System.out.println("==============================");
//
//		memberValidator.validate(member, result);// bindingResult的父介面就是Errors
//		errors = result.getAllErrors();
//		for(ObjectError oe: errors) {
////			System.out.println(oe.getCode()+ "," + oe.getDefaultMessage()+ ","+ oe.getObjectName());
//			System.out.println("oe=>" + oe);
//		}
//		if (result.hasErrors()) {
//			System.out.println("XXXXXXXXXXXXXXx");
//			return "app.updatePage";
//		}
//			memberService.update(member);
//			System.out.println("OOOOOOOOOOOOOOOOOOO");
//			ra.addFlashAttribute("insertSuccess", "更新成功");
//			return "redirect:/members";
//	}
//	@InitBinder
//	public void initBinder(WebDataBinder binder, WebRequest request) {
//		// java.util.Date
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		dateFormat.setLenient(false);
//		CustomDateEditor ce = new CustomDateEditor(dateFormat, true);
//		binder.registerCustomEditor(java.util.Date.class, ce);
//		// java.sql.Date
//		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
//		dateFormat2.setLenient(false);
//		CustomDateEditor ce2 = new CustomDateEditor(dateFormat2, true);
//		binder.registerCustomEditor(java.sql.Date.class, ce2);
//	}
//
//	@ModelAttribute("member")
//	public void findMember(@PathVariable(required = false) Long memberId, Model model) {// 為避免有15個欄位但只有6個更新且剩9個變成null，所以可使用此方法做前置，
////		先用pathVariable去讀所有欄位，用這個讀取的物件去接前端的6個更新欄位
//		Member member;
//		if (memberId != null) {
//			member = memberService.findByMemberId(memberId);
//		} else {
//			member = new Member();
//		}
//	}
//
//}
//
