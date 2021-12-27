package foodelicious.cart.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import foodelicious.member.model.Member;

@Service
public class CartService {

	@Resource
	private CartDao cartDao;

	public List<Cart> findCartListByMember(Member member_id) {
		return cartDao.findCartListByMember(member_id);
	}

	public void delete(Long id) {
		cartDao.deleteById(id);
	}
}
