package foodelicious.order.model;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService {

	@Resource
	private OrderDao orderDao;

	public Optional<Order> findByOrderId(Long id) {
		return orderDao.findById(id);
	}

	public List<Order> findAllOrder() {
		return orderDao.findAll();
	}

	public Order updateOrder(Order order) {
		return orderDao.save(order);
	}

	public void deleteByOrderId(Long id) {
		orderDao.deleteById(id);
	}

}
