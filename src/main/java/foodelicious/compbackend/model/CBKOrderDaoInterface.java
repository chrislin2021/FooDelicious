package foodelicious.compbackend.model;

import java.util.List;

import foodelicious.orders.model.OrdersBean;

public interface CBKOrderDaoInterface {
	
	public List<OrdersBean> getAllOrders();

}
