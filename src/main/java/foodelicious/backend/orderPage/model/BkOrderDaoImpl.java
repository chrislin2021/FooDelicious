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

    @Override
    public BkOrder findById(Long orderId) {

        BkOrder bkOrder = bkOrderRepository.findById(orderId).orElse(null);

        return bkOrder;
    }

    @Override
    public String update(Long orderId, BkOrder bkOrder) {

        BkOrder orders = bkOrderRepository.findById(orderId).orElse(null);

        if(orders != null){
            orders.setOrdersName(bkOrder.getOrdersName());
            orders.setOrdersPhone(bkOrder.getOrdersPhone());
            orders.setOrdersAddress(bkOrder.getOrdersAddress());
            orders.setOrdersState(bkOrder.getOrdersState());
            orders.setOrdersTotal(bkOrder.getOrdersTotal());
            bkOrderRepository.save(orders);
            return "訂單資料更新成功";
        }else{
            return "訂單資料更新失敗";
        }
    }

    @Override
    public List<BkOrder> findByStatus(String orderStatus) {

        List<BkOrder> orders = bkOrderRepository.findByStatus(orderStatus);

        return orders;
    }

    @Override
    public List<BkOrder> findByStatusHandling(String orderStatus, String orderStatus2, String orderStatus3) {

        List<BkOrder> orders = bkOrderRepository.findByStatusHandling(orderStatus, orderStatus2, orderStatus3);

        return orders;
    }
}
