package foodelicious.orders.model;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrdersService {

	@Resource
	private OrdersRepository ordersRepository;

	public OrdersBean insertOrders(OrdersBean ordersBean) {
		return ordersRepository.save(ordersBean);
	}

	public OrdersBean updateOrders(OrdersBean ordersBean) {
		return ordersRepository.save(ordersBean);
	}

	public List<OrdersBean> selectOrders(Long memberId) {
		return ordersRepository.findAllByMemberId(memberId);
	}

	public List<OrdersBean> selectAll() {
		return ordersRepository.findAll();
	}

}
