package foodelicious.cart.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import foodelicious.product.model.ProductDao;

@Service
public class CartService {

	@Resource
	private CartDao cartDao;

	@Resource
	private ProductDao productDao;

	public List<Cart> findCartListByMember(Long member_id) {
		return cartDao.findCartListByMember(member_id);
	}

	public List<Cart> findAll() {
		return cartDao.findAll();
	}

	public void deleteById(Long product_id) {
		cartDao.deleteById(product_id);
	}

	public void save() {
		cartDao.save(null);
	}

	public Integer total(Integer quantity, Integer price) {
		return quantity * price;
	}

}
