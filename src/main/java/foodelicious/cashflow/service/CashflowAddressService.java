package foodelicious.cashflow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import foodelicious.cashflow.model.CashflowAddressBean;




@Service
public interface CashflowAddressService {
	
	CashflowAddressBean insertAndUpdateAddress(CashflowAddressBean cashflowBean);
	
	void deleteAddress(Long addressId);
	
	List<CashflowAddressBean> selectAddress(Long memberId);

	CashflowAddressBean getCashflowAddressBeanByMember(Long memberId);
		

}
