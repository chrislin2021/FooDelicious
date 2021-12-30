package foodelicious.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodelicious.orders.model.OrdersBean;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersBean, Long> {

	List<OrdersBean> findAllByMemberId(Long memberId);

}
