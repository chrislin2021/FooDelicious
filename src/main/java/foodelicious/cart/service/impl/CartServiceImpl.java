package foodelicious.cart.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import foodelicious.cart.model.CartBean;
import foodelicious.cart.repository.CartRepository;
import foodelicious.cart.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	private CartRepository cartRepository;

	public CartServiceImpl(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@Override
	public CartBean insertItem(CartBean cartBean) {
		return cartRepository.save(cartBean);
	}

	@Override
	public void deleteItem(Long productId) {
		cartRepository.deleteById(productId);
	}

	@Override
	public CartBean updateItem(CartBean cartBean) {
		return cartRepository.save(cartBean);
	}

	@Override
	public List<CartBean> selectItem(Long memberId) {
		return cartRepository.findAllByMemberId(memberId);
	}

}
