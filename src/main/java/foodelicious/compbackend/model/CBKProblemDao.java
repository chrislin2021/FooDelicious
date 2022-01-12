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
	
	@Autowired
	private CBKProblemRepository cbkProblemRepository;
	
//	public String insertProblem(ProblemsBean problem) {
//		 if(problem != null) {
//			 ProblemsBean insertProb = new ProblemsBean();
//			 insertProb.setProblemCategory(problem.getProblemCategory());
//			 insertProb.setProblemContent(problem.getProblemContent());
//			 insertProb.setCompanyId(problem.getCompanyId());
//			 Date now = new Date();
//			 insertProb.setProblemSubmitDate(now);
//			 cbkProblemRepository.saveAndFlush(insertProb);
//			 return "Problem insert successful!";
//		 }else {
//			 
//			 return "Problem insert fail!";
//		 }
//		 
//		
//	}
	
	public String insertProblem() {
			
			 ProblemsBean insertProb = new ProblemsBean();
			 insertProb.setProblemCategory(1);
			 insertProb.setProblemContent("a lot of things");
			 insertProb.setCompanyId(1L);
			 Date now= new Date();
			 insertProb.setProblemSubmitDate(now);
			 System.out.println("hereeeeeeeeeeeeeeee");
			 //insertProb 好像是空的
			 cbkProblemRepository.saveAndFlush(insertProb);
			 System.out.println("在這裡嗎?");
			 return "Problem insert successful!";
		 }
		 
		
	}
	
	
	

	


