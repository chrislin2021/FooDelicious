package foodelicious.member.service;

import java.util.List;

import foodelicious.backend.memberpage.model.BkMember;
import foodelicious.member.model.Member;

public interface MemberService {

	
	Member findByMemberMail(String memberMail);

	Member save(Member member);

	List<Member> findAll();

	Member findByMemberId(Long memberId);

	void update(Member member);

	void deleteByMemberId(Long memberId);

	List<Member> findByMemberMailJpa(String memberMail);
	


}
