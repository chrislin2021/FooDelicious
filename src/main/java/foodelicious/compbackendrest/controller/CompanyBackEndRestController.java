package foodelicious.compbackendrest.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import foodelicious.backend.memberpage.model.BkMember;
import foodelicious.compbackend.model.CBKProductDao;
import foodelicious.compbackend.repository.CBKProductRepository;
import foodelicious.compbackend.service.CompanyBackEndServiceInterface;
import foodelicious.product.model.Product;

@RestController
public class CompanyBackEndRestController {

	private final CompanyBackEndServiceInterface cbkServiceInterface;

	// 測試 記得最後輸入的是service interface
	private final CBKProductRepository cbk;

	// 測試 記得最後輸入的是service interface
	private final CBKProductDao cbkProductDao;

	// use the final method instead of @autowired. it's the GOOD Way of writing it
	// 跟spring DI有關 Search for spring DI 好的 壞的 醜的
	public CompanyBackEndRestController(final CompanyBackEndServiceInterface cbkServiceInterface,
			CBKProductRepository cbk, CBKProductDao cbkProductDao) {
		this.cbkServiceInterface = cbkServiceInterface;
		this.cbk = cbk;
		this.cbkProductDao = cbkProductDao;
	}

	// 測試用可不可以抓到值得寫法

//	@GetMapping("/companyProducts") // Important! /companyProduct is controller, /companyProducts is RESTController
//	public List<Product> findAllProducts(HttpSession session) { 
//		Long id =(Long) session.getAttribute("userID");
//		//System.out.println(id);
//		List<Product> products = cbk.findAllByProductCompanyId(id);
//		return products;
//		
//	}

	@GetMapping("/companyProducts") // Important! /companyProduct is controller, /companyProducts is RESTController
	public List<Product> findAllProducts(HttpSession session) {

		List<Product> products = cbkServiceInterface.getAllProducts(session);
		return products;

	}

	@GetMapping("companyProducts/update/{productId}")
	public Product findByProductId(@PathVariable Long productId) {
		return cbkServiceInterface.findByProductId(productId);
	}

	@PutMapping("/companyProducts/update/{productId}")
	public String updateProduct(@PathVariable Long productId, @RequestBody Product product) {
		return cbkProductDao.updateProduct(productId,product);
	}

	@DeleteMapping("/companyProducts/delete/{productId}")
	public String deleteProduct(@PathVariable Long productId) {

		return cbkProductDao.deleteProduct(productId);
	}

}
