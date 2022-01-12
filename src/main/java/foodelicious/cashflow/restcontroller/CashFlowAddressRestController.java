package foodelicious.cashflow.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import foodelicious.cart.service.CartService;
import foodelicious.cashflow.dao.CashAddressDao;
import foodelicious.cashflow.model.CashflowAddressBean;
import foodelicious.cashflow.service.CashflowAddressService;
import foodelicious.mail.service.MailService;
import foodelicious.member.model.Member;


@RestController
@Transactional
public class CashFlowAddressRestController {
	
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	private HttpSession session;
	private CashAddressDao cashAddressDao;
	private CashflowAddressService cashflowAddressService;
	private MailService mailService;

	
	public CashFlowAddressRestController(CashflowAddressService cashflowAddressService,EntityManager em, HttpSession session, CashAddressDao cashAddressDao, MailService mailService) {
		super();
		this.em = em;
		this.session = session;
		this.cashAddressDao = cashAddressDao;
		this.cashflowAddressService = cashflowAddressService;
		this.mailService = mailService;
	}
	
	@GetMapping("/deliverAddress")
	public String deliverAddress() {
		if (session.getAttribute("userID") != null) {
			List<CashflowAddressBean> CfB = cashflowAddressService.selectAddress((Long) session.getAttribute("addressId"));
			session.setAttribute("address", CfB);
			return "app.CashFlowAddress";
		}else {
			return "app.LoginSystem";
		}
	}
	
	@ResponseBody
	@GetMapping(path = "/shoppingCart/Address")	
	public String insertAddress(@RequestBody Long addressId, @RequestBody String commonAddress) {
		
		if (session.getAttribute("userID") == null) {
			return "{\"ans\":\"請先登入會員!!\"}";
		}
//		if (session.getAttribute("productID") == null) {
//			return "{\"ans\":\"請先購買商品!!\"}";
//		}
		
		List<CashflowAddressBean> CfB = cashflowAddressService.selectAddress((Long) session.getAttribute("addressId"));
		
		for (CashflowAddressBean CfBs : CfB) {
			if(CfBs.getAddressId() == addressId) {
				Long address = CfBs.getAddressId();
			}
			CfBs.setAddressId(CfBs.getAddressId());
			CfBs.setMemberAddress(CfBs.getMemberAddress());
			CfBs.setCommonAddress(CfBs.getCommonAddress());
			
			cashflowAddressService.insertAndUpdateAddress(CfBs);
				
		}
		return commonAddress;
	}
	
	public Long findId(Member users) {
		TypedQuery<Member> query = null;
		String hqlstr = "FROM member_data2 WHERE member_address =:user AND pwd = :pwd";
		query = em.createQuery(hqlstr, Member.class);
		query.setParameter("user", users.getMemberAddress());
		query.setParameter("pwd", users.getPwd());

		Member account =  query.getSingleResult();
		mailService.prepareAndSend("請輸入信箱@gmail.com", "title", "Sample mail subject");
		em.close();
		return account.getMemberId();
	}
	
	public List<CashflowAddressBean> findById(HttpSession session){
		Long id = (Long)
				session.getAttribute("userID");
		List<CashflowAddressBean> cashflowAB = cashAddressDao.findById(id);
		return cashflowAB;
	}	
	

	@ResponseBody
	@GetMapping("/CashFlowAddress2")
	public Map<String, Object> totalAddress() {
		Map<String, Object> data = new HashMap<>();
		data.put("session", session.getAttribute("userID"));
		return data;
	}
	

}

