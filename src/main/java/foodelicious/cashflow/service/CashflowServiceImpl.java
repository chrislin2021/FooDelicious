package foodelicious.cashflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodelicious.cashflow.model.CashflowAddressBean;
import foodelicious.cashflow.repository.CashAddressRepository;
import foodelicious.member.model.Member;
import foodelicious.member.repository.MemberRepositoryImpl;

@Service
public class CashflowServiceImpl implements CashflowAddressService{
	
	private CashAddressRepository cashAddressRepository;
	
	
	@Autowired
	private MemberRepositoryImpl memberRepositoryImpl;
	
	public CashflowServiceImpl(CashAddressRepository cashAddressRepository) {
		this.cashAddressRepository = cashAddressRepository;
	}
	
	@Override
	public CashflowAddressBean insertAndUpdateAddress(CashflowAddressBean cashflowAddressBean) {
		return cashAddressRepository.save(cashflowAddressBean);
	}
	
	@Override
	public void deleteAddress(Long addressId) {
		cashAddressRepository.deleteById(addressId);
	}
	
	@Override
	public List<CashflowAddressBean> selectAddress(Long memberId){
		return cashAddressRepository.findAllByFkmemberid(memberId);
	}

	@Override
	public CashflowAddressBean getCashflowAddressBeanByMember(Long memberId) {
		
		Member members = memberRepositoryImpl.findByMemberId(memberId);
		return cashAddressRepository.findByMember(members);
	}

}
