package foodelicious.orders.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import foodelicious.cart.model.CartBean;
import foodelicious.cart.service.CartService;
import foodelicious.cart.service.SearchService;
import foodelicious.discount.service.DiscountService;
import foodelicious.orders.model.OrdersBean;
import foodelicious.orders.model.OrdersDetailBean;
import foodelicious.orders.service.OrdersDetailService;
import foodelicious.orders.service.OrdersService;
import foodelicious.product.model.Product;

@Controller
public class OrdersController {

	private HttpSession session;

	private CartService cartService;

	private OrdersBean ordersBean;

	private OrdersService ordersService;

	@SuppressWarnings("unused")
	private DiscountService discountService;

	private SearchService searchService;

	private OrdersDetailService ordersDetailService;

	public OrdersController(HttpSession session, CartService cartService, OrdersBean ordersBean,
			OrdersService ordersService, DiscountService discountService, SearchService searchService,
			OrdersDetailService ordersDetailService) {
		super();
		this.session = session;
		this.cartService = cartService;
		this.ordersBean = ordersBean;
		this.ordersService = ordersService;
		this.discountService = discountService;
		this.searchService = searchService;
		this.ordersDetailService = ordersDetailService;
	}

	@ResponseBody
	@PostMapping("/orders/insert")
	public void orders(@RequestBody OrdersBean orders) {

		OrdersBean ordersBean = new OrdersBean();

		Date date = new Date();

		Timestamp timeStamp = new Timestamp(date.getTime());

		ordersBean.setMemberId((Long) session.getAttribute("userID"));
		ordersBean.setOrderDate(timeStamp);
		ordersBean.setOrdersName(orders.getOrdersName());
		ordersBean.setOrdersPhone(orders.getOrdersPhone());
		ordersBean.setOrdersAddress(orders.getOrdersAddress());
		ordersBean.setOrdersState("訂單處理中");
		ordersBean.setOrdersTotal((Integer) session.getAttribute("priceTotal"));

		ordersService.insertOrders(ordersBean);
		this.ordersBean = ordersBean;
	}

	@ResponseBody
	@PostMapping("/ordersDetail/insert")
	public void ordersDetail(@RequestBody String ordersDetail) {

		List<CartBean> carts = cartService.selectItem((Long) session.getAttribute("userID"));

		List<Product> products = searchService.findAll();

		for (CartBean cart : carts) {
			OrdersDetailBean ordersDetailBean = new OrdersDetailBean();
			ordersDetailBean.setOrdersId(ordersBean.getOrdersId());
			ordersDetailBean.setProduct_id(cart.getProductId());
			ordersDetailBean.setQuantity(cart.getQuantity());
			ordersDetailService.insertOrderDetail(ordersDetailBean);

			for (Product product : products) {
				if (cart.getProductId() == product.getProductId()) {
					product.setProductId(cart.getProductId());
					product.setProductCategories(product.getProductCategories());
					product.setProductCategories_name(product.getProductCategories_name());
					product.setProductName(product.getProductName());
					product.setProductCompany(product.getProductCompany());
					product.setProductPrice(product.getProductPrice());
					product.setProductPics(product.getProductPics());
					product.setProductContent(product.getProductContent());
					product.setProductStock(product.getProductStock() - cart.getQuantity());
					product.setProductStatus(product.getProductStatus());
					product.setProductKeywords(product.getProductKeywords());
					product.setProductInsertDate(product.getProductInsertDate());
					product.setProductSalesFigures(product.getProductSalesFigures() + cart.getQuantity());
					product.setProductCompanyId(product.getProductCompanyId());
					searchService.save(product);
				}
			}

//			===============a lot of problems===============
//			if ((Long) session.getAttribute("discountId") != null) {
//				discountService.deleteItem((Long) session.getAttribute("discountId"));
//			}

			cartService.deleteItem(cart.getCartId());
			session.removeAttribute("discountContent");
		}
	}

	@ResponseBody
	@GetMapping("/viewOrders")
	public List<OrdersBean> viewOrders() {
		return ordersService.selectOrders((Long) session.getAttribute("userID"));
	}

	@ResponseBody
	@GetMapping("/viewOrders/pages/{orderStatus}")
	public List<OrdersBean> findByStatus(@PathVariable String orderStatus) {
		return ordersService.selectIdAndStatus((Long) session.getAttribute("userID"), orderStatus);
	}

	@ResponseBody
	@GetMapping("/toOrderDetailPage/{ordersId}")
	public List<OrdersDetailBean> toOrdersDetailPage(@PathVariable Long ordersId) {
		List<OrdersDetailBean> details = ordersDetailService.selectOrdersDetail(ordersId);

		return details;
	}

	@GetMapping("/ordersEnd")
	public String ordersEnd() {
		return "app.OrdersEnd";
	}

	@GetMapping("/memberOrders")
	public String memberOrders() {
		return "app.ViewOrders";
	}

}
