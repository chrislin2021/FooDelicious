package foodelicious.backend.mamagerPage.repository;

import foodelicious.backend.memberPage.model.BkMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BkManagerRepository extends CrudRepository<BkMember, Long> {
}
