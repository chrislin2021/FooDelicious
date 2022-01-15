package foodelicious.compbackendrest.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import foodelicious.compbackend.model.CBKProblemDao;
import foodelicious.compbackend.model.CBKProductDao;
import foodelicious.compbackend.model.ProblemsBean;
import foodelicious.compbackend.repository.CBKProblemRepository;
import foodelicious.compbackend.repository.CBKProductRepository;
import foodelicious.compbackend.service.CompanyBackEndServiceInterface;
import foodelicious.mail.service.MailService;
import foodelicious.product.model.Product;

@RestController
public class CompanyBackEndRestController {

	private final CompanyBackEndServiceInterface cbkServiceInterface;

	// 測試 記得最後輸入的是service interface
	private final CBKProductRepository cbk;

	private final CBKProblemRepository cpk;

	// 測試 記得最後輸入的是service interface
	private final CBKProductDao cbkProductDao;

	private final CBKProblemDao cbkProblemDao;

	@Autowired
	private MailService mailService;

	// use the final method instead of @autowired. it's the GOOD Way of writing it
	// 跟spring DI有關 Search for spring DI 好的 壞的 醜的
	public CompanyBackEndRestController(final CompanyBackEndServiceInterface cbkServiceInterface,
			CBKProductRepository cbk, CBKProductDao cbkProductDao, CBKProblemRepository cpk,
			CBKProblemDao cbkProblemDao) {
		this.cbkServiceInterface = cbkServiceInterface;
		this.cbk = cbk;
		this.cpk = cpk;
		this.cbkProductDao = cbkProductDao;
		this.cbkProblemDao = cbkProblemDao;
	}

	@GetMapping("/companyProducts") // Important! /companyProduct is controller, /companyProducts is RESTController
	public List<Product> findAllProducts(HttpSession session) {

		List<Product> products = cbkServiceInterface.getAllProducts(session);
		return products;

	}

	@GetMapping("/companyProducts/search/{categories}")
	public List<Product> findAllByName(@PathVariable Integer categories, HttpSession session) {
		Long productCompanyId = (Long) session.getAttribute("userID");
		return cbkServiceInterface.findByType(categories, productCompanyId);
	}

	@GetMapping("/companyProducts/{productName}")
	public List<Product> findAllByName(@PathVariable String productName) {
		List<Product> products = cbkProductDao.findByName(productName);
		return products;
	}

	@GetMapping("/companyProducts/{productName}/{categories}")
	public List<Product> findByNameAndType(@PathVariable String productName, @PathVariable Integer categories, HttpSession session) {
		Long productCompanyId = (Long) session.getAttribute("userID");
		List<Product> products = cbkProductDao.findByNameAndType(productName, categories, productCompanyId);
		return products;
	}

	@GetMapping("/companyProducts/update/{productId}")
	public Product findByProductId(@PathVariable Long productId) {
		// return cbkServiceInterface.findByProductId(productId);
		return cbkServiceInterface.findByProductId(productId);
	}

	@PutMapping("/companyProducts/update/{productId}")
	public String updateProduct(@PathVariable Long productId, @RequestBody Product product) {
		return cbkServiceInterface.updateProduct(productId, product);
	}

	@PutMapping("/companyProblemReport/{companyId}")
	public String companyProblem(@RequestBody ProblemsBean problem, HttpSession session) {
		// System.out.println("in rest controller");
		String sender = (String) session.getAttribute("memberMail");
		String companyName = (String) session.getAttribute("userName");
		String mailSentStatus = mailService.receiveProblemReports(sender, companyName);

		return cbkProblemDao.insertProblem(problem);
	}
	
	//新增商品與圖片
	@PostMapping("/companyProductsAdd")
	public String post(@RequestParam(name = "productCategories") Short productCategories, @RequestParam(name = "productCategoriesName") String productCategoriesName,
			@RequestParam(name = "productName") String productName, @RequestParam(name = "productCompany") String productCompany,
			@RequestParam(name = "productCompanyId") Long productCompanyId,@RequestParam(name = "productPrice") Integer productPrice,
			@RequestParam(name = "productContent") String productContent,@RequestParam(name = "productStock") Integer productStock,
			@RequestParam(name = "productStatus") String productStatus,@RequestParam(name = "productKeywords") String productKeywords,
			@RequestParam(name = "productSalesFigures") Integer productSalesFigures,
			MultipartFile photo, HttpSession session)
			throws IllegalStateException, IOException, ParseException {

		String fileName = photo.getOriginalFilename();
		String saveFileDirPath = session.getServletContext().getRealPath("/") + "img\\";

		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		String uuid = UUID.randomUUID().toString();
		fileName = uuid + suffixName;
		String finalPath = saveFileDirPath + File.separator + fileName;

		File saveFileDestPath = new File(finalPath);
		photo.transferTo(saveFileDestPath);

		Product product = new Product();
		product.setProductCategories(productCategories);
		product.setProductCategories_name(productCategoriesName);
		product.setProductName(productName);
		product.setProductCompany(productCompany);
		product.setProductCompanyId(productCompanyId);
		product.setProductPrice(productPrice);
		product.setProductPics(fileName);
		product.setProductContent(productContent);
		product.setProductStock(productStock);
		product.setProductStatus(productStatus);
		product.setProductKeywords(productKeywords);
		product.setProductSalesFigures(productSalesFigures);
		
		boolean insertStatus = cbkProductDao.saveProduct(product);
		
		if(insertStatus == true) {
			//如何在這邊加alert說商品insert成功
			return "app.CompanyProduct2";
		}
		else {
			//如何在這邊加alert說商品insert成功
			return "app.CompanyProductAdd";
		}

		
	}

	@DeleteMapping("/companyProducts/delete/{productId}")
	public String deleteProduct(@PathVariable Long productId) {

		return cbkServiceInterface.deleteProduct(productId);
	}

}
