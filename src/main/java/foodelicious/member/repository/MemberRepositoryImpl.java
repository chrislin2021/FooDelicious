package foodelicious.member.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import foodelicious.member.model.Member;
import foodelicious.member.service.MemberService;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	
	@PersistenceContext//類似autowired的工作
	EntityManager em;//類似session

	@Override
	public Member findByMemberMail(String memberMail) {
		return em.find(Member.class, memberMail);
	}

	@Override
	public Member save(Member member) {
		em.persist(member);
		return em.find(Member.class, member.getMemberId());
	}

	@Override
	public List<Member> findAll() {
		String hql = "FROM Member";//Member類別名稱
		List<Member> members = em.createQuery(hql, Member.class).getResultList();
		return members;
	}


//	@Override
//	public void save(Member member) {
//		em.persist(member);		
//	}


}
