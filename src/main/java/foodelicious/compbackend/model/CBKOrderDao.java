package foodelicious.compbackend.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import foodelicious.orders.model.OrdersBean;

@Repository
public class CBKOrderDao implements CBKOrderDaoInterface {
	
	public List<OrdersBean> getAllOrders(){
		return null;
	}

}
