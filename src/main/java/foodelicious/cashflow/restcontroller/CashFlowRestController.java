package foodelicious.cashflow.restcontroller;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import foodelicious.cart.model.CartBean;
import foodelicious.cart.service.CartService;
import foodelicious.cashflow.service.CashflowAddressService;
import foodelicious.mail.service.MailService;
import foodelicious.member.model.Member;
import foodelicious.member.service.MemberService;
import foodelicious.orders.model.OrdersBean;
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
	private OrdersService ordersService;
	private MemberService memberService;

	public CashFlowRestController(EntityManager em, HttpSession session, CartService cartService,
			MailService mailService, OrdersService ordersService,MemberService memberService) {
		super();
		this.em = em;
		this.session = session;
		this.cartService = cartService;
		this.mailService = mailService;
		this.ordersService = ordersService;
		this.memberService = memberService;
	}

	@ResponseBody
	@GetMapping(path = "/shoppingCart/CashflowList2")
	public HashMap<Object, Object> CashFlowTable(Model m, Long productId, Long memberId) {
		HashMap<Object, Object> table = new HashMap<Object, Object>();
		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));
		
//		Long userID = CashflowAddressService.useIdFindShareArea(id).get(0).getFk_account_id();
//		String title = articleService.useIdFindShareArea(id).get(0).getArticle_title();
//		String userMail = memberService.findByMemberId(userID).getMemberMail();
		
		for (CartBean cart : carts) {
			Product product = null;
			if (productId == cart.getProductId()) {
				product = cart.getProduct();
			}



			table.put("memberId", cart.getMemberId());
			table.put("memberName", cart.getMember().getMemberName());
			table.put("memberPhone", cart.getMember().getMemberPhone());
			table.put("memberMail", cart.getMember().getMemberMail());
			table.put("memberAddress", cart.getMember().getMemberAddress());
			table.put("productId", cart.getProductId());
			table.put("productName", cart.getProduct().getProductName());
			table.put("quantity", cart.getQuantity());
			table.put("productprice", cart.getProduct().getProductPrice());
//			mailService.prepareAndSend(userMail,"請輸入信箱@gmail.com", "title", "Sample mail subject");
			em.close();

		}
		
		return table;
	}
}
