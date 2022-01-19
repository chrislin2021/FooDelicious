package foodelicious.compbackend.model;

import java.util.List;

import foodelicious.backend.productPage.model.BkProduct;

public interface CBKProblemDaoInterface {

	public String insertProblem(ProblemsBean problem);

	public List<ProblemsBean> getAllProblems(Long problemCompanyId);

	public List<BkProduct> findAllProblemsByStatus(String status, Long problemCompanyId);
}
