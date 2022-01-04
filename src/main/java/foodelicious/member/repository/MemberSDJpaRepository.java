package foodelicious.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import foodelicious.member.model.Member;


@Repository
public interface MemberSDJpaRepository extends JpaRepository<Member, Long> {

	@Query(value = "select * from member_data2 where member_mail = :memberMail",nativeQuery = true)
	Member checkLogin(String memberMail);

	Member findByMemberMail(String memberMail);
	
	@Query(value = "select * from member_data2 where member_status = :memberStatus",nativeQuery = true)
	Member findByMemberStatus(String memberStatus);
	
	public Member findByMemberMailAndPwd(String memberMail, String pwd);

}
