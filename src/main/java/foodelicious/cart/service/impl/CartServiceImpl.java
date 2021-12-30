package foodelicious.cart.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import foodelicious.cart.model.CartBean;
import foodelicious.cart.repository.CartRepository;
import foodelicious.cart.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Resource
	private CartRepository cartRepository;

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
