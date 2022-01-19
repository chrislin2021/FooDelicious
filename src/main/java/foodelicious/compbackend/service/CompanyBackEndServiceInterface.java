package foodelicious.compbackend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PutMapping;

import foodelicious.backend.memberpage.model.BkMember;
import foodelicious.backend.productPage.model.BkProduct;
import foodelicious.compbackend.model.ProblemsBean;
import foodelicious.member.model.Member;
import foodelicious.orders.model.OrdersBean;
import foodelicious.orders.model.OrdersDetailBean;
import foodelicious.product.model.Product;


public interface CompanyBackEndServiceInterface {
	
	
	//product dao for /companyProduct page
	public List<Product> getAllProducts(HttpSession session);

	public String deleteProduct(Long productId);
	
	public Product findByProductId(Long productId);

	public String updateProduct(Long productId, Product product);

	public List<Product> findByType(Integer categories, Long productCompanyId);
	
	public List<Product> findByName(String productName);
	
	public List<Product> findByNameAndType(String productName, Integer categories, Long productCompanyId);
	
	public boolean saveProduct(Product product);
	
	
	
	//detail dao for /companyMain page
	public Member findByCompanyId(Long companyId);
	
	public String updateCompanyDetail(Long companyId, Member company);
	
	
	//problem dao for /companyProblemReport/{companyId}
	public String insertProblem(ProblemsBean problem);
	
	

	//product dao for /companyOrder
	public List<OrdersDetailBean> findByCompanyProductId(Long productCompanyId);
	
	
	
	//problem dao for /companyProblems
	public List<ProblemsBean> getAllProblems(Long problemCompanyId);

	public List<BkProduct> findAllProblemsByStatus(String status, Long problemCompanyId);
	
	
	
	

	


}
