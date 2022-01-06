package foodelicious.backend.managerPage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import foodelicious.backend.memberpage.model.BkMember;

@Repository
public interface BkManagerRepository extends CrudRepository<BkMember, Long> {
}
