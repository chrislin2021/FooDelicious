package foodelicious.orders.service;

import java.util.List;

import foodelicious.orders.model.OrdersBean;

public interface OrdersService {

	OrdersBean insertOrders(OrdersBean ordersBean);

	OrdersBean updateOrders(OrdersBean ordersBean);

	List<OrdersBean> selectOrders(Long memberId);

	List<OrdersBean> selectAll();

}
