package foodelicious.member.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import foodelicious.member.model.Member;
import foodelicious.member.repository.MemberSDJpaRepository;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	
	MemberSDJpaRepository memberRepository;
	
	
	
	@Autowired
	public MemberServiceImpl(MemberSDJpaRepository memberRepository) {
		this.memberRepository = memberRepository;
	}


	@Override
	public Boolean save(Member member) {
		memberRepository.save(member);
		return true;
//		System.out.println("memberService" + member);
	}


//	@Override
//	public boolean checkLogin(Member member) {
//		return memberRepository.checkLogin(member);
//	}


//	@Override
//	public Long findId(Member member) {
//		return memberRepository.findId(member);
	}



