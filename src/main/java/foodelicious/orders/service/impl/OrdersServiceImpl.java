package foodelicious.orders.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import foodelicious.orders.model.OrdersBean;
import foodelicious.orders.repository.OrdersRepository;
import foodelicious.orders.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Resource
	private OrdersRepository ordersRepository;

	@Override
	public OrdersBean insertOrders(OrdersBean ordersBean) {
		return ordersRepository.save(ordersBean);
	}

	@Override
	public OrdersBean updateOrders(OrdersBean ordersBean) {
		return ordersRepository.save(ordersBean);
	}

	@Override
	public List<OrdersBean> selectOrders(Long memberId) {
		return ordersRepository.findAllByMemberId(memberId);
	}

	@Override
	public List<OrdersBean> selectAll() {
		return ordersRepository.findAll();
	}

}
