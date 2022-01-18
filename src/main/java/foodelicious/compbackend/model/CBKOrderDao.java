package foodelicious.compbackend.model;


import java.util.List;

import org.springframework.stereotype.Repository;

import foodelicious.compbackend.repository.CBKOrderRepository;
import foodelicious.orders.model.OrdersDetailBean;

@Repository
public class CBKOrderDao implements CBKOrderDaoInterface {
	
	private final CBKOrderRepository cbkOrderRepository;
	
	

	public CBKOrderDao(final CBKOrderRepository cbkOrderRepository) {
		this.cbkOrderRepository = cbkOrderRepository;
	}



	@Override
	public List <OrdersDetailBean> findByCompanyProductId(Long productCompanyId) {
		List<OrdersDetailBean> allOrderDetails = cbkOrderRepository.findAll();
		
//		List<OrdersDetailBean> bean = null;
//		for(int i = 0 ; i < allOrderDetails.size() ; i ++) {
//			OrdersDetailBean orderDetailBean = allOrderDetails.get(i);
//			Object productDetail = orderDetailBean.getProductDetail();
//			
//		}
		
		
		
		
		
		
		
		return allOrderDetails;
	}
	
	

}
