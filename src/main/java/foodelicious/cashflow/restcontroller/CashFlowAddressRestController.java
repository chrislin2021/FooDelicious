package foodelicious.cashflow.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import foodelicious.cart.model.CartBean;
import foodelicious.cashflow.model.CashflowAddressBean;
import foodelicious.cashflow.model.EcPayBean;
import foodelicious.cashflow.service.CashflowAddressService;
import foodelicious.mail.service.MailService;
import foodelicious.member.model.Member;
import foodelicious.member.repository.MemberRepositoryImpl;
import foodelicious.member.service.MemberService;
import foodelicious.orders.model.OrdersBean;
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

	public CashFlowAddressRestController(CashflowAddressService cashflowAddressService,
			MemberRepositoryImpl memberRepositoryImpl, MemberService memberService, MailService mailService,
			HttpSession session) {

		this.cashflowAddressService = cashflowAddressService;
		this.mailService = mailService;
		this.memberRepositoryImpl = memberRepositoryImpl;
		this.session = session;
		this.memberService = memberService;
	}

	@PostMapping("/Address.controller")
	public void postAddress(@RequestBody Map<String, String> params, HttpSession session) {

		Long id = (Long) session.getAttribute("userID");

		cashflowAddressService.pushAddress(params, id);
	}

	@ResponseBody
	@GetMapping(path = "/CashflowAddress")
	public Map<String, Object> useIdfindAddress(Model m) {
		Map<String, Object> data = new HashMap<>();
		Member mem = memberService.findByMemberId((Long) session.getAttribute("userID"));
		data.put("session", session.getAttribute("userID"));
		data.put("userName", session.getAttribute("userName"));
		data.put("memberId", mem.getMemberId());
		data.put("memberMail", mem.getMemberMail());
		data.put("memberId", mem.getMemberName());
		data.put("memberAddress", mem.getMemberAddress());
		data.put("title", cashflowAddressService.findAll());

		session.setAttribute("data", data);
		return data;
	}

	@ResponseBody
	@DeleteMapping("/deleteAddress/{id}")
	public void deleteAddress(@PathVariable(value = "id", required = false) Long id) {
		System.out.println(id);
		cashflowAddressService.useAddressIdDelete(id);
	}

	@PutMapping("/addressUpdate/{id}")
	public void updateArticle(@RequestBody Map<String, String> params, @PathVariable("id") Long addressId) {
		cashflowAddressService.UpdateAddress(params, addressId);
	}

//	// 發送請求給綠界
//	@PostMapping(value = "/toPayECpay", consumes = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public EcPayBean aioCheckOutALL(HttpServletRequest request) {
//		AioCheckOutALL aio = new AioCheckOutALL();
//		AllInOne aioOne = new AllInOne("");
//		EcPayBean ecpay = new EcPayBean();
//		Cookie[] cookieList = request.getCookies();
//		String memberCookieID = null;
//		if (cookieList != null) {
//			for (Cookie cookie : cookieList) {
//				if (cookie.getName().equals("userId")) {
//					memberCookieID = cookie.getValue();
//				}
//			}
//		}
//		Member m = memberService.findByMemberId((Long) session.getAttribute("userID"));
//		Optional<OrdersBean> orderBean = OrdersService.getNewestOrderByMember(memberID.get());
//		aio.setMerchantID("2000132");
//		aio.setMerchantTradeNo("NeverStarveYY" + String.valueOf(orderBean.get().getPkOrderId()));
//		aio.setMerchantTradeDate(
//				String.valueOf(orderBean.get().getOrderDate()).substring(0, 19).replace("T", " ").replace("-", "/"));
//		aio.setTotalAmount(String.valueOf(orderBean.get().getTotalCost().intValue()));
//		aio.setTradeDesc("test shopping");
//		aio.setItemName(orderBean.get().getOrdersName());
//		aio.setReturnURL("http://localhost:8080/Order/returnURL");
//		aio.setOrderResultURL("http://localhost:8080/Order/order/EcpayOrder");
//		ecpay.setHi(aioOne.aioCheckOut(aio, null));
//		return ecpay;
//	}
//
//	// 0707訂單的展示
//	@GetMapping("order/NowOrder")
//	public String getNowOrder(Model model, @CookieValue(value = "userId") String userid) {
//
//		Member m = null;
//		m = memberService.findByMemberId((Long) session.getAttribute("userID"));
//		if (m != null) {
//			List<OrdersBean> order = OrdersService.findOrderByMemberBean(m);
//			model.addAttribute("id", m);
//			model.addAttribute("orderSet", order);
//			System.out.println("找到你囉" + order);
//		}
//		return "order/OrderMember";
//	}
//
//	// 0709給綠界的
//	@PostMapping("order/EcpayOrder")
//	public String getEcpayOrder(Model model, @RequestParam("RtnCode") int RtnCode,
//			@RequestParam("MerchantTradeNo") String MerchantTradeNo, HttpServletResponse response,
//			HttpServletRequest request) {
//		Member member = (Member) session.getAttribute("member");
//		Member memberCookie = null;
//		String userid = null;
//		Cookie[] cookieList = request.getCookies();
//
//		if (cookieList != null) {
//			for (Cookie cookie : cookieList) {
//				if (cookie.getName().equals("userId")) {
//					userid = cookie.getValue();
//				}
//			}
//		}
//		if (userid != null) {
//
//			memberCookie = memberService.getMamberById(Integer.valueOf(userid)).get();
//		}
//		if (memberCookie != null) {
//			System.out.println("08是餅乾啦耖");
//			List<OrdersBean> order = OrdersService.findOrderByMemberBean(memberCookie);
//			model.addAttribute("id", memberCookie);
//			model.addAttribute("orderSet", order);
//		} else if (member != null) {
//			System.out.println("08是Session啦");
//			List<OrdersBean> order = OrdersService.findOrderByMemberBean(member);
//			model.addAttribute("id", member);
//			model.addAttribute("orderSet", order);
//		} else {
//			System.out.println("08是死人啦");
//			member = memberService.getMamberById(1).get();
//			List<OrdersBean> order = OrdersService.findOrderByMemberBean(member);
//			model.addAttribute("id", member);
//			model.addAttribute("orderSet", order);
//		}
//		if (RtnCode == 1) {
//			System.out.println("^_^凸，抓到你囉字串" + MerchantTradeNo);
//			String mno = MerchantTradeNo.replace("NeverStarveYY", "");
//			int ino = Integer.valueOf(mno);
//			OrdersBean findorder = orderservice.findByPkOrderId(ino).get();
//			findorder.setTrading(1);
//			System.out.println("抓" + findorder);
//			OrdersBean.update(findorder);
//
//		}
//
//		return "order/OrderMember";
//	}
//
//	@GetMapping("list/{id}")
//	public String getliString(@PathVariable int id, Model model) {
//		Optional<OrdersBean> order = orderservice.findByPkOrderId(id);
//		OrdersBean o = order.get();
//		Set<OrderListBean> list = o.getOrderListBean();
//		model.addAttribute("orderList", list);
//		return "order/OrderList";
//
//	}

}
