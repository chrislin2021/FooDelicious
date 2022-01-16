package foodelicious.compbackend.model;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import foodelicious.compbackend.repository.CBKCompanyDetailRepository;
import foodelicious.member.model.Member;

@Repository
@Transactional
public class CBKDetailDao implements CBKDetailDaoInterface {
	
	@PersistenceContext
	EntityManager em;
	
	private CBKCompanyDetailRepository cbkDetailRepository;

	public CBKDetailDao(final CBKCompanyDetailRepository cbkDetailRepository) {
		this.cbkDetailRepository = cbkDetailRepository;
	}
	
	
	public Member findByCompanyId(Long companyId) {
		Member company = cbkDetailRepository.findById(companyId).orElse(null);
		if(company != null) {
			return company;
		}
		return null;
	}
}
