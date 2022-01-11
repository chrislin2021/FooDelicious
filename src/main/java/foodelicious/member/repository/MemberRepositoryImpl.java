package foodelicious.member.repository;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import foodelicious.member.model.Member;
import foodelicious.member.service.MemberService;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

	@PersistenceContext // 類似autowired的工作
	EntityManager em;// 類似session

	@Resource
	MemberJpaRepository jpaa;

	@Override
	public Member save(Member member) {
		em.persist(member);
		return em.find(Member.class, member.getMemberId());
	}

	@Override
	public List<Member> findAll() {
//		String hql = "FROM Member";//Member類別名稱
//		List<Member> members = em.createQuery(hql, Member.class).getResultList();
		List<Member> members = jpaa.findAll();
		return members;
	}

	@Override
	public Member findByMemberId(Long memberId) {
		return em.find(Member.class, memberId);
	}

	@Override
	public void update(Member member) {
		em.merge(member);
	}

	@Override
	public void deleteByMemberId(Long memberId) {
		Member member = em.find(Member.class, memberId);
		em.remove(member);
	}

	@Override
	public Member findByMemberMail(String memberMail) {
		String hql ="FROM member_data2 m WHERE m.memberMail = :mail";
		List<Member> members = em.createQuery(hql, Member.class)
				.setParameter("mail", memberMail)
		.getResultList();
		
		if(members.size() > 0) {
			System.out.println(members.get(0));
			return members.get(0);
			
		}else {
			return null;
		}
	}
	

}
