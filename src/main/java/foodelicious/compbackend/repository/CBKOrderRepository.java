package foodelicious.compbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import foodelicious.backend.orderPage.model.BkOrder;
import foodelicious.orders.model.OrdersDetailBean;

@Repository
public interface CBKOrderRepository extends JpaRepository<OrdersDetailBean, Integer> {
	
//	@Query(value = "SELECT * FROM orders WHERE orders_state = ?", nativeQuery = true)
//    List<OrdersDetailBean> findBy

}
