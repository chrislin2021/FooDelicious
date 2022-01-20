package foodelicious.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodelicious.orders.model.OrdersBean;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersBean, Long> {

	OrdersBean findByOrdersId(Long ordersId);

	List<OrdersBean> findAllByMemberId(Long memberId);

	List<OrdersBean> findAllByMemberIdAndOrdersState(Long memberId, String state);

}
