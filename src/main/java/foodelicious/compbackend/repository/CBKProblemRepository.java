package foodelicious.compbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import foodelicious.compbackend.model.ProblemsBean;

@Repository
public interface CBKProblemRepository extends JpaRepository<ProblemsBean, Integer> {

	@Query(value = "SELECT * FROM problem_report WHERE company_id = ?", nativeQuery = true)
	List<ProblemsBean> findAll(Long problemCompanyId);

}
