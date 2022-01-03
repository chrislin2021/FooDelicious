package foodelicious.cashflow;


import java.util.HashMap;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import foodelicious.cart.model.CartBean;
import foodelicious.orders.model.OrdersBean;
import foodelicious.product.model.Product;

//@Repository
@Controller
@Transactional
public class CashFlow {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	private SessionFactory sessionFactory;
	

	
	@ResponseBody
	@GetMapping(path = "/CashflowList")
	public HashMap<String, Object> CashFlowTable() {
		HashMap<String, Object> table = new HashMap<String, Object>(); 
		Session session = sessionFactory.openSession();
		CartBean paytablelist = new CartBean();
		OrdersBean paytablelist2 = new OrdersBean();
		Product pro = new Product();
//		paytablelist.setMemberId(2L);
//		session.get(CartBean, member_id );
		
//		session.get("memberId", CartBean.memberId);
		
		table.put("memberId", paytablelist.getMemberId());
		table.put("productId", paytablelist.getProductId());
		table.put("productname", pro.getProductName());
		table.put("Quantity", paytablelist.getQuantity());
		table.put("Productprice", pro.getProductPrice());
		table.put("getOrdersTotal", paytablelist2.getOrdersTotal());
		
			
		session.close(); 
		em.close();
		return table;
		
	}
}
				

