package foodelicious.cart.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class CartService {

	@Resource
	private CartDao cartDao;

	public void deleteCartById(Long id) {
		cartDao.deleteById(id);
	}

//	更新還沒寫完
	public List<Cart> updateCartById(Long id) {
		List<Cart> list = new ArrayList<Cart>();

		return list;
	}

	public List<Cart> findAllById(Long id) {
		List<Cart> list = new ArrayList<Cart>();
		list.add((Cart) cartDao.findAllById(null));
		return list;
	}
}
