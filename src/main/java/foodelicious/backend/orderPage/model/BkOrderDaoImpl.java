package foodelicious.backend.orderPage.model;

import foodelicious.backend.orderPage.repository.BkOrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BkOrderDaoImpl implements BkOrderDao{

    private BkOrderRepository bkOrderRepository;

    public BkOrderDaoImpl(BkOrderRepository bkOrderRepository) {
        this.bkOrderRepository = bkOrderRepository;
    }

    @Override
    public List<BkOrder> findAllOrder() {

        List<BkOrder> orders = (List<BkOrder>) bkOrderRepository.findAll();

        return orders;
    }
}
