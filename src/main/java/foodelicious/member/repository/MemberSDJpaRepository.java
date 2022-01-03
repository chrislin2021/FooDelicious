package foodelicious.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodelicious.member.model.Member;


@Repository
public interface MemberSDJpaRepository extends JpaRepository<Member, Long> {

	boolean checkLogin(Member member);



}
