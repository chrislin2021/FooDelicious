package foodelicious.cashflow.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import foodelicious.cashflow.model.CashflowAddressBean;
import foodelicious.cashflow.model.EcPayBean;
import foodelicious.cashflow.service.CashflowAddressService;
import foodelicious.mail.service.MailService;
import foodelicious.member.model.Member;
import foodelicious.member.repository.MemberRepositoryImpl;
import foodelicious.member.service.MemberService;
import foodelicious.orders.model.OrdersBean;
import foodelicious.orders.model.OrdersDetailBean;
import foodelicious.orders.service.OrdersDetailService;
import foodelicious.orders.service.OrdersService;

@RestController
@Transactional
public class CashFlowAddressRestController {

	@PersistenceContext
	EntityManager em;

	private HttpSession session;
	private CashflowAddressService cashflowAddressService;
	private MailService mailService;
	private MemberRepositoryImpl memberRepositoryImpl;
	private MemberService memberService;
	private OrdersService ordersService;
	private OrdersDetailService orderdetailService;

	public CashFlowAddressRestController(CashflowAddressService cashflowAddressService,
			MemberRepositoryImpl memberRepositoryImpl, MemberService memberService, MailService mailService,
			HttpSession session,OrdersService ordersService,OrdersDetailService orderdetailService) {

		this.cashflowAddressService = cashflowAddressService;
		this.mailService = mailService;
		this.memberRepositoryImpl = memberRepositoryImpl;
		this.session = session;
		this.memberService = memberService;
		this.ordersService = ordersService;
		this.orderdetailService = orderdetailService;
	}

//	@PostMapping("/Address.controller")
//	public void postAddress(@RequestBody Map<String, String> params, HttpSession session) {
//
//		Long id = (Long) session.getAttribute("userID");
//
//		cashflowAddressService.pushAddress(params, id);
//	}

	
	@GetMapping(path = "/CashflowAddress")
	public Map<String, Object> useIdfindAddress(Model m) {
		Map<String, Object> data = new HashMap<>();
		Member mem = memberService.findByMemberId((Long) session.getAttribute("userID"));
		data.put("session", session.getAttribute("userID"));
		data.put("userName", session.getAttribute("userName"));
		data.put("memberId", mem.getMemberId());
		data.put("memberMail", mem.getMemberMail());
		data.put("memberName", mem.getMemberName());
		data.put("memberAddress", mem.getMemberAddress());
		data.put("title", cashflowAddressService.findAll());

		session.setAttribute("data", data);
		return data;
	}



}
