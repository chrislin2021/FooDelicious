package foodelicious.cart.service;

import java.util.List;

import foodelicious.cart.model.CartBean;

public interface CartService {

	CartBean insertAndUpdateItem(CartBean cartBean);

	void deleteItem(Long cartId);

	List<CartBean> selectItem(Long memberId);

}
