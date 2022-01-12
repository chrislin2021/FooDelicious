package foodelicious.orders.service.impl;

import org.springframework.stereotype.Service;

import foodelicious.orders.model.OrdersDetailBean;
import foodelicious.orders.repository.OrdersDetailRepository;
import foodelicious.orders.service.OrdersDetailService;

@Service
public class OrderDetailServiceImpl implements OrdersDetailService {

	OrdersDetailRepository ordersDetailRepository;

	public OrderDetailServiceImpl(OrdersDetailRepository ordersDetailRepository) {
		super();
		this.ordersDetailRepository = ordersDetailRepository;
	}

	@Override
	public OrdersDetailBean insertOrderDetail(OrdersDetailBean ordersDetailBean) {
		return ordersDetailRepository.save(ordersDetailBean);
	}

}
