package foodelicious.cashflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodelicious.cashflow.model.CashflowAddressBean;
import foodelicious.member.model.Member;

@Repository
public interface CashAddressRepository extends JpaRepository<CashflowAddressBean, Long>{
	
	List<CashflowAddressBean> findAllByFkmemberid(Long memberId);

	CashflowAddressBean findByMember(Member members);

//	List<CashflowAddressBean> useIdFindMail();
			
	
}
