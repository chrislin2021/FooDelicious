package foodelicious.backend.memberpage.repository;

import foodelicious.backend.memberpage.model.BkMember;
import org.springframework.data.repository.CrudRepository;

public interface BkCrudRepository extends CrudRepository<BkMember, Integer> {
}
