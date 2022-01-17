package foodelicious.cashflow.restcontroller;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import foodelicious.cashflow.model.CashflowAddressBean;
import foodelicious.cashflow.service.CashflowAddressService;
import foodelicious.mail.service.MailService;
import foodelicious.member.model.Member;
import foodelicious.member.repository.MemberRepositoryImpl;

@RestController
@Transactional
public class CashFlowAddressRestController{

	@PersistenceContext
	EntityManager em;

	private HttpSession session;
	private CashflowAddressService cashflowAddressService;
	private MailService mailService;
	private MemberRepositoryImpl memberRepositoryImpl;

	public CashFlowAddressRestController(CashflowAddressService cashflowAddressService,
			MemberRepositoryImpl memberRepositoryImpl, MailService mailService, HttpSession session) {

		this.cashflowAddressService = cashflowAddressService;
		this.mailService = mailService;
		this.memberRepositoryImpl = memberRepositoryImpl;
		this.session = session;
	}

//	@GetMapping("/address")
//	public String address() {
//		
//		if (session.getAttribute("userID") != null) {
//			List<CashflowAddressBean> cfab = cashflowAddressService.selectAddress((Long) session.getAttribute("userID"));
//			
//			session.setAttribute("commonAddress", CommonAddress)
//			}
//	}

	@ResponseBody
	@GetMapping(path = "/address/CashflowAddress")
	public HashMap<Object, Object> CashFlowAddressTable(Model m, Long productId, Long memberId, HttpSession session) {
		HashMap<Object, Object> table = new HashMap<Object, Object>();

		CashflowAddressBean cfab = cashflowAddressService
				.getCashflowAddressBeanByMember((Long) session.getAttribute("userID"));
		Member members = memberRepositoryImpl.findByMemberId(memberId);

//		session.setAttribute("commonAddress", cfab.getCommonAddress());

		cfab.setCommonAddress(cfab.getCommonAddress());

		table.put("memberMail", members.getMemberMail());
		table.put("memberId", members.getMemberName());
		table.put("memberAddress", members.getMemberAddress());
		table.put("CommonAddress", cfab.getCommonAddress());
		em.close();
		mailService.prepareAndSend("請輸入信箱@gmail.com", "title", "Sample mail subject");

		return table;
	}

	@ResponseBody
	@PostMapping("/address/insert")
	public String insertAddress(@RequestBody String jS) {

		JSONObject obj = JSON.parseObject(jS);
		Object pid = obj.get("pid");
		String pidTemp = "" + pid;
		Long addressId = Long.parseLong(pidTemp);
		String memberAddress = null;
		String commonAddress = null;

		if (session.getAttribute("userID") == null) {
			return "{\\\"ans\\\":\\\"請先登入會員!!\\\"}";
		}
		Boolean same = false;

		List<CashflowAddressBean> cfab = cashflowAddressService.selectAddress((Long) session.getAttribute("userID"));

		for (CashflowAddressBean CashfAdd : cfab) {
			if (CashfAdd.getAddressId() == addressId) {
				Long member = CashfAdd.getAddressId();
			}
			CashfAdd.setFk_member_id(CashfAdd.getFk_member_id());
			CashfAdd.setAddressId(CashfAdd.getAddressId());
			CashfAdd.setMemberAddress(CashfAdd.getMemberAddress());
			CashfAdd.setCommonAddress(CashfAdd.getCommonAddress());
			cashflowAddressService.insertAndUpdateAddress(CashfAdd);

			same = true;
			break;
		}
		if (same != true) {
			CashflowAddressBean cashflowAddressBean = new CashflowAddressBean();
			cashflowAddressBean.setFk_member_id((Long) session.getAttribute("userID"));
			cashflowAddressBean.setAddressId(addressId);
			cashflowAddressBean.setMemberAddress(memberAddress);
			cashflowAddressBean.setCommonAddress(commonAddress);
			cashflowAddressService.insertAndUpdateAddress(cashflowAddressBean);
		}

		return "{\"ans\":\"" + "此地址 " + commonAddress + " 已加入寄貨地址" + "\"}";
	}

	@ResponseBody
	@DeleteMapping("/address/{addressId}")
	public void deleteAddress(@PathVariable Long addressId) {

		List<CashflowAddressBean> cfab = cashflowAddressService.selectAddress((Long) session.getAttribute("userID"));

		for (CashflowAddressBean CashfAdd : cfab) {
			if (CashfAdd.getAddressId() == addressId) {
				cashflowAddressService.deleteAddress(CashfAdd.getAddressId());
				break;
			}
		}
	}

	@ResponseBody
	@PutMapping("/address/{pid}")
	public void updateAddress(@PathVariable String pid) {

		Long addressId = Long.parseLong(pid);

		List<CashflowAddressBean> cfab = cashflowAddressService.selectAddress((Long) session.getAttribute("userID"));

		for (CashflowAddressBean CashfAdd : cfab) {
			if (CashfAdd.getAddressId() == addressId) {
				cashflowAddressService.insertAndUpdateAddress(CashfAdd);
			}
			break;
		}

	}

	@ResponseBody
	@GetMapping("/address/show")
	public List<CashflowAddressBean> selectAddress() {

		List<CashflowAddressBean> cfab = cashflowAddressService.selectAddress((Long) session.getAttribute("userID"));

		return cfab;
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
//		Optional<Member> memberID = memberService.getMamberById(Integer.valueOf(memberCookieID));
//		Optional<OrdersBean> orderBean = orderservice.getNewestOrderByMember(memberID.get());
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
//		m = MemberService.getMemberById(Integer.valueOf(userid)).get();
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
//
}
