package foodelicious.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import foodelicious.member.model.Member;
import foodelicious.member.repository.MemberRepository;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	MemberRepository memberRepository;

//	@Autowired
	public MemberServiceImpl(MemberRepository memberRepository) {
		super();
		this.memberRepository = memberRepository;
	}

	@Override
	public Member save(Member member) {
		return memberRepository.save(member);
	}

//	@Override
//	public boolean save(Member member) {
//		memberRepository.save(member);
//		return true;
////		System.out.println("memberService" + member);
//	}

//	@Override
//	public Member checkLogin(String member) {
//		return memberRepository.checkLogin(member);
//	}
//
//
//	@Override
//	public  Member findId(String memberMail) {
//		return memberRepository.findByMemberMail(memberMail);
//	}
//
//	@Override
//	public Member findByMemberMailAndPwd(String memberMail, String pwd) {
//		return memberRepository.findByMemberMailAndPwd(memberMail, pwd);
//	}

	@Override
	public Member findByMemberMail(String memberMail) {
		return memberRepository.findByMemberMail(memberMail);
	}

	@Override
	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	@Override
	public Member findByMemberId(Long memberId) {
		return memberRepository.findByMemberId(memberId);
	}

	@Override
	public void update(Member member) {
		memberRepository.update(member);
	}


}