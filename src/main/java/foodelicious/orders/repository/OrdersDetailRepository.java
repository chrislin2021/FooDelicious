package foodelicious.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import foodelicious.orders.model.OrdersDetailBean;

public interface OrdersDetailRepository extends JpaRepository<OrdersDetailBean, Long> {

}
