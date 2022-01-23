package foodelicious.cashflow.restcontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import foodelicious.cart.model.CartBean;
import foodelicious.cart.service.CartService;
import foodelicious.cashflow.model.CashflowAddressBean;
import foodelicious.cashflow.model.EcPayBean;
import foodelicious.cashflow.service.CashflowAddressService;

import foodelicious.mail.service.MailService;
import foodelicious.member.model.Member;
import foodelicious.member.service.MemberService;
import foodelicious.orders.model.OrdersBean;
import foodelicious.orders.model.OrdersDetailBean;
import foodelicious.orders.service.OrdersDetailService;
import foodelicious.orders.service.OrdersService;
import foodelicious.product.model.Product;

@RestController
@Transactional
public class CashFlowRestController {

	@PersistenceContext
	EntityManager em;

	private HttpSession session;
	private CartService cartService;
	private MailService mailService;
//	private CashflowOrdersService cashflowordersService;
	private OrdersService ordersService;
	private MemberService memberService;
	private OrdersDetailService ordersDetailService;
	private CashflowAddressService cashflowAddressService;
//	private CashflowOrdersListService cashflowOrdersListService;

	public CashFlowRestController(EntityManager em, HttpSession session, CartService cartService,
			MailService mailService,OrdersService ordersService,OrdersDetailService ordersDetailService,
			 MemberService memberService,
			CashflowAddressService cashflowAddressService) {
		super();
		this.em = em;
		this.session = session;
		this.cartService = cartService;
		this.mailService = mailService;
		this.ordersService = ordersService;
//		this.cashflowordersService = cashflowordersService;
		this.memberService = memberService;
		this.cashflowAddressService = cashflowAddressService;
		this.ordersDetailService =ordersDetailService;
//		this.cashflowOrdersListService = cashflowOrdersListService;
	}

	@ResponseBody
	@GetMapping(path = "/shoppingCart/CashflowList2")
	public List<HashMap<Object, Object>> CashFlowTable(Model m, Long productId, Long memberId) {
		List<HashMap<Object, Object>> tables = new ArrayList<HashMap<Object, Object>>();
		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));
		List<OrdersBean> orders = ordersService.selectOrders((Long) session.getAttribute("userID"));
//		Long userID = CashflowAddressService.useIdFindShareArea(id).get(0).getFk_account_id();
//		String title = articleService.useIdFindShareArea(id).get(0).getArticle_title();
//		String userMail = memberService.findByMemberId(userID).getMemberMail();

		for (CartBean cart : carts) {
			
			Product product = null;
			if (productId == cart.getProductId()) {
				product = cart.getProduct();
			}
			for (OrdersBean order : orders) {		
				HashMap<Object, Object> table = new HashMap<Object, Object>();
				table.put("memberId", cart.getMemberId());
				table.put("memberName", cart.getMember().getMemberName());
				table.put("memberPhone", cart.getMember().getMemberPhone());
				table.put("memberMail", cart.getMember().getMemberMail());
				table.put("memberAddress", cart.getMember().getMemberAddress());
				table.put("productId", cart.getProductId());
				table.put("productName", cart.getProduct().getProductName());
				table.put("quantity", cart.getQuantity());
				table.put("productprice", cart.getProduct().getProductPrice());
				table.put("orderId", order.getOrdersId());
				table.put("orderTotal", order.getOrdersTotal());
				em.close();
				tables.add(table);
//				mailService.prepareAndSend(userMail,"請輸入信箱@gmail.com", "title", "Sample mail subject");
			}
		}
		
		return tables;
		
		
	}
	
	@PostMapping("/address.insert")
	public void postAddress(@RequestBody Map<String, String> params) {
		System.out.println("======================================================");
		System.out.println(params.get("commonaddress"));
//		Long id = (Long) session.getAttribute("userID");
//		System.out.println(id);
		cashflowAddressService.pushAddress(params);
	}
	
	
//	@PostMapping("/address/insert")
//	public String saveAddress(){
//		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));
//		
//		
//		for (CartBean cart : carts) {
//		CashflowAddressBean cashflowAddressBean = new CashflowAddressBean();
//		cashflowAddressBean.setMemberId((Long) session.getAttribute("userID"));
//		cashflowAddressBean.setAddressId(addressId);
//		cashflowAddressBean.setMemberAddress(cart.getMember().getMemberAddress());
//		cashflowAddressBean.setCommonAddress(commonAddress);
//		
//		cashflowAddressService.save(commonAddress);
//		}	
//	}
	
	
	@GetMapping("/ecpay")
	public EcPayBean pay() {
		AioCheckOutALL aio = new AioCheckOutALL();
		AllInOne aioOne = new AllInOne("");
		EcPayBean ecpay = new EcPayBean();
		aio.setMerchantID("2000132");
		aio.setMerchantTradeNo("FoodeliciousYY252" );
		aio.setMerchantTradeDate("20220127");
		aio.setTotalAmount(String.valueOf(session.getAttribute("priceTotal")));
		aio.setTradeDesc("test shopping");
		aio.setItemName("foodelicious");
		aio.setReturnURL("http://localhost:8080/CashflowList");
		aio.setOrderResultURL("http://localhost:8080/Order/order/EcpayOrder");
		ecpay.setHi(aioOne.aioCheckOut(aio, null));
		return ecpay;
		
	}
	
	
//	// 發送請求給綠界
//	@PostMapping(value = "/toPayECpay", consumes = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public EcPayBean aioCheckOutALL(HttpServletRequest request) {
//		AioCheckOutALL aio = new AioCheckOutALL();
//		AllInOne aioOne = new AllInOne("");
//		EcPayBean ecpay = new EcPayBean();
//		Member m = memberService.findByMemberId((Long) session.getAttribute("userID"));
//		OrdersBean orderBean = cashflowordersService.selectOrdersId((Long) session.getAttribute("ordersId"));
//		aio.setMerchantID("2000132");
//		aio.setMerchantTradeNo("FoodeliciousYY" + String.valueOf(orderBean.getOrdersId()));
//		aio.setMerchantTradeDate(
//				String.valueOf(orderBean.getOrdersDate()).substring(0, 19).replace("T", " ").replace("-", "/"));
//		aio.setTotalAmount(String.valueOf(orderBean.getOrdersTotal().intValue()));
//		aio.setTradeDesc("test shopping");
//		aio.setItemName(orderBean.getOrdersName());
//		aio.setReturnURL("http://localhost:8080/Order/returnURL");
//		aio.setOrderResultURL("http://localhost:8080/order/EcpayOrder");
//		ecpay.setHi(aioOne.aioCheckOut(aio, null));
//		return ecpay;
//	}
	

	
	
//	// 0709給綠界的
//	@PostMapping("order/EcpayOrder")
//	public String getEcpayOrder(Model model, @RequestParam("RtnCode") int RtnCode,
//			@RequestParam("MerchantTradeNo") String MerchantTradeNo, HttpServletResponse response,
//			HttpServletRequest request) {
//		Member member = memberService.findByMemberId((Long) session.getAttribute("userID"));
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
//			memberCookie = memberService.findByMemberId((Long) session.getAttribute("userID"));
//		}
//		if (memberCookie != null) {
//			System.out.println("08是餅乾啦耖");
//			List<OrdersBean> order = CashflowOrdersService.findOrderByMember(member);
//			model.addAttribute("id", memberCookie);
//			model.addAttribute("orderSet", order);
//		} else if (member != null) {
//			System.out.println("08是Session啦");
//			List<OrdersBean> order = CashflowOrdersService.findOrderByMember(member);
//			model.addAttribute("id", member);
//			model.addAttribute("orderSet", order);
//		} else {
//			System.out.println("08是死人啦");
//			member = memberService.findByMemberId((Long) session.getAttribute("userID"));
//			List<OrdersBean> order = OrdersService.findOrderByMemberBean(member);
//			model.addAttribute("id", member);
//			model.addAttribute("orderSet", order);
//		}
//		if (RtnCode == 1) {
//			System.out.println("^_^凸，抓到你囉字串" + MerchantTradeNo);
//			String mno = MerchantTradeNo.replace("NeverStarveYY", "");
//			int ino = Integer.valueOf(mno);
//			OrdersBean findorder = OrdersService.findByPkOrderId(ino).get();
//			findorder.setTrading(1);
//			System.out.println("抓" + findorder);
//			OrdersBean.setOrdersId(OrdersBean.getOrdersId());
//			OrdersBean.update(findorder);
//
//		}
//
//		return "order/OrderMember";
//	}
//
//	@GetMapping("list/{id}")
//	public String getliString(@PathVariable int id, Model model) {
//		Optional<OrdersBean> order = CashflowOrdersService.selectOrdersId((Long) session.getAttribute("userID"));
//		OrdersBean o = order.get();
//		Set<OrdersDetailBean> list = o.getOrderDetail();
//		model.addAttribute("orderList", list);
//		return "order/OrderList";
//
//	}
	
}
