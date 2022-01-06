package foodelicious.compbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import foodelicious.backend.memberpage.model.BkMember;
import foodelicious.compbackend.model.CBKOrderDaoInterface;
import foodelicious.compbackend.model.CBKProductDaoInterface;
import foodelicious.orders.model.OrdersBean;
import foodelicious.product.model.Product;

@Service
@Transactional
public class CompanyBackEndService implements CompanyBackEndServiceInterface{
	
	private CBKProductDaoInterface cbkProductDaoInterface;
	
	private CBKOrderDaoInterface cbkOrderDaoInterface;
	
	public CompanyBackEndService (final CBKProductDaoInterface cbkProductDaoInterface,CBKOrderDaoInterface cbkOrderDaoInterface) {
		this.cbkProductDaoInterface = cbkProductDaoInterface;
		this.cbkOrderDaoInterface = cbkOrderDaoInterface;
	}
	

	
	

}
