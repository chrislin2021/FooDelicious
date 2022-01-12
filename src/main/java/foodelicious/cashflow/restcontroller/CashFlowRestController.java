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
import foodelicious.mail.service.MailService;
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

	public CashFlowRestController(EntityManager em, HttpSession session, CartService cartService,
			MailService mailService, OrdersService ordersService) {
		super();
		this.em = em;
		this.session = session;
		this.cartService = cartService;
		this.mailService = mailService;
		this.ordersService = ordersService;
	}

	@ResponseBody
	@GetMapping(path = "/shoppingCart/CashflowList2")
	public HashMap<Object, Object> CashFlowTable(Model m, Long productId) {
		HashMap<Object, Object> table = new HashMap<Object, Object>();
//		System.out.println(session.getAttribute("userID"));
		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));
		List<OrdersBean> orders = ordersService.selectOrders((Long) session.getAttribute("userID"));

		for (CartBean cart : carts) {
			Product product = null;
			if (productId == cart.getProductId()) {
				product = cart.getProduct();
			}


//			table.put("totalprice", order.getordersTotal());

//			table.put("memberId", cart.getMemberId());
			table.put("productId", cart.getProductId());
			table.put("productName", cart.getProduct().getProductName());
			table.put("quantity", cart.getQuantity());
			table.put("productprice", cart.getProduct().getProductPrice());

			mailService.prepareAndSend("請輸入信箱@gmail.com", "title", "Sample mail subject");
			em.close();

		}

		return table;
//		return "app.CashflowList";

	}
//	public Integer totalAmount() {
//		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));
//		Integer totalAmount = 0;
//		for (CartBean cart : carts) {
//			Product product = cart.getProduct();
//			totalAmount += product.getProductPrice() * cart.getQuantity();
//		}
//		return totalAmount;
//	}
}
