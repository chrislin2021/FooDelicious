package foodelicious.cart.model;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import foodelicious.member.model.Member;
import foodelicious.product.model.ProductDao;

@Service
@Transactional
public class CartService {

	@Resource
	private CartRepository cartRepository;

	public CartBean insertItem(CartBean cartBean) {
		return cartRepository.save(cartBean);
	}

	public void deleteItem(Long cart_id) {
		cartRepository.deleteById(cart_id);
	}

	public CartBean updateItem(CartBean cartBean) {
		return cartRepository.save(cartBean);
	}

	public List<CartBean> selectItem(Long member_id) {
		return cartRepository.findAllByMemberId(member_id);
	}

}
