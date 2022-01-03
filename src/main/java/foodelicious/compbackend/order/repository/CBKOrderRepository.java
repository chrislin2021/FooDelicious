package foodelicious.compbackend.order.repository;

import org.springframework.data.repository.CrudRepository;

import foodelicious.orders.model.OrdersBean;

public interface CBKOrderRepository extends CrudRepository<OrdersBean, Integer> {

}
