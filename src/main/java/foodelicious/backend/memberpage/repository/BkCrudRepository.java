package foodelicious.backend.memberpage.repository;


import foodelicious.backend.memberpage.model.BkMember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BkCrudRepository extends CrudRepository<BkMember, Integer> {

    @Query(value="SELECT * FROM member_data2 WHERE member_mail LIKE %?%", nativeQuery = true)
    List<BkMember> findByEmail(String searchEmail);

}
