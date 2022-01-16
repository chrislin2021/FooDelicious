package foodelicious.compbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import foodelicious.backend.memberpage.model.BkMember;
import foodelicious.member.model.Member;

@Repository
public interface CBKCompanyDetailRepository extends  CrudRepository<Member, Long>{
	


}
