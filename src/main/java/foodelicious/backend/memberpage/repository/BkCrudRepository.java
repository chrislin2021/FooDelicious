package foodelicious.backend.memberpage.repository;



import java.util.List;
import java.util.Optional;

import foodelicious.backend.memberpage.model.BkMember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface BkCrudRepository extends CrudRepository<BkMember, Long> {

    @Query(value="SELECT * FROM member_data2 WHERE member_mail LIKE %?%", nativeQuery = true)
    List<BkMember> findByEmail(String searchEmail);

    @Query(value="SELECT * FROM member_data2 WHERE member_id = ?", nativeQuery = true)
    Optional<BkMember> findById(Long memberId);

//    @Query(value="DELETE FROM member_data WHERE member_id = ?1", nativeQuery = true)
//    void deleteById(Long memberId);
}
