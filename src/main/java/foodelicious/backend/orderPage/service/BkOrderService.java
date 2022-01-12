package foodelicious.backend.orderPage.service;

import foodelicious.backend.orderPage.model.BkOrder;

import java.util.List;

public interface BkOrderService {

    public List<BkOrder> findAllOrder();
}
