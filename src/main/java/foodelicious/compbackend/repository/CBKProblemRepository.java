package foodelicious.compbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodelicious.compbackend.model.ProblemsBean;

@Repository
public interface CBKProblemRepository extends JpaRepository<ProblemsBean, Long> {

}
