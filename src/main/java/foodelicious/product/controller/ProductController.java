package foodelicious.product.controller;

import java.io.File;
import java.io.IOException;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import foodelicious.product.model.Product;
import foodelicious.product.model.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//show all data
	@GetMapping("/Product")
	public String  productlist(String productName,Model m) {
		List<Product> pros = productService.findAll();
		m.addAttribute("pros", pros);
		return "app.Product";
	}
	
	//create model Attribute to bind for data
	@GetMapping("/backend/productAdd")
	public String showNewProductForm(Model m) {
		Product product = new Product();
		m.addAttribute("product",product);
		return "app.BackendProductAdd";
	}
	
	//save product to database
	@PostMapping("/Product")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);
		return "redirect:/Product";
	}
	
	//show datadetail
	@GetMapping("/Product/{productId}")
    public String findproduct(@PathVariable Integer productId, Model model) {
		List<Product> prod = productService.findByProductId(productId);
		model.addAttribute("prod",prod);
        return "app.ProductDetail";
    }
	
	//新增商品與圖片
//	@ResponseBody
	@PostMapping("/backend/product")
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

		Product t = new Product();
		t.setProductCategories(productCategories);
		t.setProductCategories_name(productCategoriesName);
		t.setProductName(productName);
		t.setProductCompany(productCompany);
		t.setProductCompanyId(productCompanyId);
		t.setProductPrice(productPrice);
		t.setProductPics(fileName);
		t.setProductContent(productContent);
		t.setProductStock(productStock);
		t.setProductStatus(productStatus);
		t.setProductKeywords(productKeywords);
//		t.setProductInsertDate(productInsertDate);
		t.setProductSalesFigures(productSalesFigures);
		
		productService.saveProduct(t);

		return "redirect:/backend/product";
	}


}
