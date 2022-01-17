package foodelicious.cashflow.service;

import java.util.List;

import foodelicious.cashflow.model.CashflowAddressBean;




//@Service
public interface CashflowAddressService {
	
	CashflowAddressBean insertAndUpdateAddress(CashflowAddressBean cashflowBean);
	
	void deleteAddress(Long addressId);
	
	List<CashflowAddressBean> selectAddress(Long memberId);

	CashflowAddressBean getCashflowAddressBeanByMember(Long memberId);
		
//	List<CashflowAddressBean> useIdFindMail(Long memberId);
}
