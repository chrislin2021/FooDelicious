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

	//更新問題狀態存入資料庫中
	@Override
	public String updateCompanyProblem(Integer problemId, ProblemsBean problem) {
		ProblemsBean updatedProblem = em.find(ProblemsBean.class, problemId);
		if(updatedProblem != null) {
			updatedProblem.setProblemStatus(problem.getProblemStatus());
			cbkProblemRepository.save(updatedProblem);
			return "問題回報狀態更新成功!";
		}
		return "找不到問題，請重新來過。";
	}
	
	//更新問題狀態前先找到更新前的資料
	@Override
	public ProblemsBean findProblemById(Integer problemId) {
		ProblemsBean problem = em.find(ProblemsBean.class, problemId);
		return problem;
	}

	
	//後臺回覆廠商問題
	@Override
	public String updateCompanyResponse(Integer problemId, ProblemsBean problem) {
		ProblemsBean updatedProblemResponse = em.find(ProblemsBean.class, problemId);
		if(updatedProblemResponse != null) {
			updatedProblemResponse.setProblemResponse(problem.getProblemResponse());
			cbkProblemRepository.save(updatedProblemResponse);
			return "問題回覆成功";
		}
		return "問題回覆失敗。請重新來過。";
	}


}
