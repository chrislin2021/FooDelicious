package foodelicious.member.service;

import java.util.List;

import foodelicious.backend.memberpage.model.BkMember;
import foodelicious.member.model.Member;

public interface MemberService {

	
//	Member checkLogin(String member);
//
//	Member findId(String memberMail);
//
//
//	Member findByMemberMailAndPwd(String memberMail, String pwd);

	Member findByMemberMail(String memberMail);

//	boolean save(Member member);
	
	Member save(Member member);

	List<Member> findAll();

	
	
	


}
