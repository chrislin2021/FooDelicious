package foodelicious.backend.orderPage.repository;

import foodelicious.backend.orderPage.model.BkOrder;
import org.springframework.data.repository.CrudRepository;

public interface BkOrderRepository extends CrudRepository<BkOrder, Integer> {
}
