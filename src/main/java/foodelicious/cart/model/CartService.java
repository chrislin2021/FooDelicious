package foodelicious.cart.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class CartService {

	@Resource
	private CartRepository cartRepository;

	public CartBean insertAndUpdateItem(CartBean cartBean) {
		return cartRepository.save(cartBean);
	}

	public void deleteItem(Long cartId) {
		cartRepository.deleteById(cartId);
	}

	public List<CartBean> selectItem(Long memberId) {
		return cartRepository.findAllByMemberId(memberId);
	}

}
