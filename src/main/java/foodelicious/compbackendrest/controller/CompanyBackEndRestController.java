package foodelicious.compbackendrest.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import foodelicious.compbackend.model.CBKProblemDao;
import foodelicious.compbackend.model.CBKProductDao;
import foodelicious.compbackend.model.ProblemsBean;
import foodelicious.compbackend.repository.CBKProductRepository;
import foodelicious.compbackend.service.CompanyBackEndServiceInterface;
import foodelicious.mail.service.MailService;
import foodelicious.product.model.Product;

@RestController
public class CompanyBackEndRestController {

	private final CompanyBackEndServiceInterface cbkServiceInterface;

	// 測試 記得最後輸入的是service interface
	private final CBKProductRepository cbk;

	// 測試 記得最後輸入的是service interface
	private final CBKProductDao cbkProductDao;
	
	private final CBKProblemDao cbkProblemDao;
	
	@Autowired
	private MailService mailService;

	// use the final method instead of @autowired. it's the GOOD Way of writing it
	// 跟spring DI有關 Search for spring DI 好的 壞的 醜的
	public CompanyBackEndRestController(final CompanyBackEndServiceInterface cbkServiceInterface,
			CBKProductRepository cbk, CBKProductDao cbkProductDao) {
		this.cbkServiceInterface = cbkServiceInterface;
		this.cbk = cbk;
		this.cbkProductDao = cbkProductDao;
		this.cbkProblemDao = new CBKProblemDao();
	}

	@GetMapping("/companyProducts") // Important! /companyProduct is controller, /companyProducts is RESTController
	public List<Product> findAllProducts(HttpSession session) {

		List<Product> products = cbkServiceInterface.getAllProducts(session);
		return products;

	}

	@GetMapping("companyProducts/update/{productId}")
	public Product findByProductId(@PathVariable Integer productId) {
		//return cbkServiceInterface.findByProductId(productId);
		return cbkServiceInterface.findByProductId(productId);
	}

	@PutMapping("/companyProducts/update/{productId}")
	public String updateProduct(@PathVariable Integer productId, @RequestBody Product product) {
		return cbkServiceInterface.updateProduct(productId,product);
	}
	
	
	@GetMapping(path="/companyProblemReport")
	public String companyProblem(@RequestBody ProblemsBean problem, HttpSession session) {
		 String sender = (String)session.getAttribute("memberMail");
		 String companyName = (String)session.getAttribute("userName");
		 Long companyId = (Long)session.getAttribute("userID");
		 String mailSent = mailService.receiveProblemReports(sender,companyName);
		 return cbkProblemDao.insertProblem(problem,companyId);
	}


	@DeleteMapping("/companyProducts/delete/{productId}")
	public String deleteProduct(@PathVariable Integer productId) {
		
		return cbkProductDao.deleteProduct(productId);
	}

}
