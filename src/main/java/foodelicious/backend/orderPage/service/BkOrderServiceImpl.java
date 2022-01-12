package foodelicious.backend.orderPage.service;

import foodelicious.backend.orderPage.model.BkOrder;
import foodelicious.backend.orderPage.model.BkOrderDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BkOrderServiceImpl implements BkOrderService{

    private BkOrderDao bkOrderDao;

    public BkOrderServiceImpl(BkOrderDao bkOrderDao) {
        this.bkOrderDao = bkOrderDao;
    }

    @Override
    public List<BkOrder> findAllOrder() {
        return bkOrderDao.findAllOrder();
    }
}
