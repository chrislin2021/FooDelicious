package foodelicious.compbackend.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import foodelicious.compbackend.repository.CBKProblemRepository;

@Repository
@Transactional
public class CBKProblemDao {
	
	@PersistenceContext
	EntityManager em;
	
	private CBKProblemRepository cbkProblemRepository;
	
	public CBKProblemDao(final CBKProblemRepository cbkProblemRepository) {
		this.cbkProblemRepository = cbkProblemRepository;
	}

	public String insertProblem(ProblemsBean problem) {
		 if(problem != null) {
			 
			 cbkProblemRepository.save(problem);
			 
			 return "Problem insert successful!";
		 }else {
			 
			 return "Problem insert fail!";
		 }
		 
		
	}
	

		}
	
	
	

	


