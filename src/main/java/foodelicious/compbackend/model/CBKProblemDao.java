package foodelicious.compbackend.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import foodelicious.backend.productPage.model.BkProduct;
import foodelicious.compbackend.repository.CBKProblemRepository;

@Repository
@Transactional
public class CBKProblemDao implements CBKProblemDaoInterface {

	@PersistenceContext
	EntityManager em;

	private CBKProblemRepository cbkProblemRepository;

	public CBKProblemDao(final CBKProblemRepository cbkProblemRepository) {
		this.cbkProblemRepository = cbkProblemRepository;
	}

	public String insertProblem(ProblemsBean problem) {
		if (problem != null) {

			cbkProblemRepository.save(problem);

			return "問題回報成功! 我們將盡快與您聯繫。";
		} else {

			return "問題回報失敗。請重新再試一次。";
		}

	}

	@Override
	public List<ProblemsBean> getAllProblems() {
		List<ProblemsBean> problems = cbkProblemRepository.findAll();
		return problems;
	}

	
	@Override
	public List<ProblemsBean> findAllProblemsByStatus(String status) {
		
		return cbkProblemRepository.findProblemsByStatus(status);
	}

	@Override
	public List<ProblemsBean> findAllProblemsByCategory(Integer catNum) {
		
		return cbkProblemRepository.findAllProblemsByCategory(catNum);
	}

	@Override
	public List<ProblemsBean> findAllProblemsByKeywords(String keywords) {
		
		return cbkProblemRepository.findAllProblemsByKeywords(keywords);
	}


}
