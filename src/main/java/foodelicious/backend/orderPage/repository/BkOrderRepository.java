package foodelicious.backend.orderPage.repository;

import foodelicious.backend.memberpage.model.BkMember;
import foodelicious.backend.orderPage.model.BkOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BkOrderRepository extends CrudRepository<BkOrder, Long> {

    @Query(value = "SELECT * FROM orders WHERE orders_state = ?", nativeQuery = true)
    List<BkOrder> findByStatus(String orderStatus);

    @Query(value = "SELECT * FROM orders WHERE (orders_state in(?,?,?))",nativeQuery = true)
    List<BkOrder> findByStatusHandling(String orderStatus, String orderStatus2, String orderStatus3);
}
