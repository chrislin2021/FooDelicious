package foodelicious.cart.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import foodelicious.member.model.Member;

@Service
public class CartService {

	@Resource
	private CartDao cartDao;

	public List<Cart> findByMember(Member Member_id) {
		return cartDao.findByMember(Member_id);
	}

}
