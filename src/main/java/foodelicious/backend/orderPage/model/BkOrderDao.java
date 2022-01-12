package foodelicious.backend.orderPage.model;

import java.util.List;

public interface BkOrderDao {

    public List<BkOrder> findAllOrder();
}
