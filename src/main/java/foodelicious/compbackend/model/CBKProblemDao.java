package foodelicious.compbackend.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import foodelicious.compbackend.repository.CBKProblemRepository;

@Repository
@Transactional
public class CBKProblemDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	private CBKProblemRepository cbkProblemRepository;
	
	public String insertProblem(ProblemsBean problem) {
		 if(problem != null) {
			 cbkProblemRepository.saveAndFlush(problem);
			 return "Problem insert successful!";
		 }else {
			 
			 return "Problem insert fail!";
		 }
		 
		
	}
	
	

}
