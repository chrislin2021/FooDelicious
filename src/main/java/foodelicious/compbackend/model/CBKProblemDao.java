package foodelicious.compbackend.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import foodelicious.compbackend.repository.CBKProblemRepository;
import foodelicious.member.model.Member;

@Repository
@Transactional
public class CBKProblemDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	private CBKProblemRepository cbkProblemRepository;
	
	public String insertProblem(ProblemsBean problem, Long companyId) {
		 if(problem != null) {
			 String content = problem.getProblemContent();
			 em.createNativeQuery("INSERT INTO problem_report ('problem_category','problem_content','fk_company_id')"
			 		+ " VALUES (?,?,?)")
			 		.setParameter(1, problem.getProblemCategory())
			 		.setParameter(2,problem.getProblemContent())
			 		.setParameter(3, companyId)
			 		.executeUpdate();
			 
			 return "Problem insert successful!";
		 }else {
			 
			 return "Problem insert fail!";
		 }
		 
		
	}
	
	

}
