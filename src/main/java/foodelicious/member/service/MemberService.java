package foodelicious.member.service;

import foodelicious.member.model.Member;

public interface MemberService {


	Boolean save(Member member);
	
	Member checkLogin(String member);

	Member findId(String memberMail);

//	Member findByMemberStatus(Member eMid);

	Member findByMemberMailAndPwd(String memberMail, String pwd);
	
	


}
