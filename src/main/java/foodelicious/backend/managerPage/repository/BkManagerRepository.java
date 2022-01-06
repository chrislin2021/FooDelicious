package foodelicious.backend.managerPage.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import foodelicious.backend.memberPage.model.BkMember;

import java.util.List;

@Repository
public interface BkManagerRepository extends CrudRepository<BkMember, Long> {

    @Query(value = "SELECT * FROM member_data2 WHERE (member_status in('admin','company'))",nativeQuery = true)
    public List<BkMember> findAllManager();

    @Query(value = "SELECT * FROM member_data2 WHERE (member_status in('admin','company')) AND member_mail LIKE %?%",nativeQuery = true)
    public List<BkMember> findByMail(String mail);
}
