package foodelicious.cart.service;

import java.util.List;

import foodelicious.cart.model.CartBean;

public interface CartService {

	CartBean insertItem(CartBean cartBean);

	void deleteItem(Long cartId);

	CartBean updateItem(CartBean cartBean);

	List<CartBean> selectItem(Long memberId);

}
