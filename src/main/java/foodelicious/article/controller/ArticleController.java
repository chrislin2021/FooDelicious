package foodelicious.article.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import foodelicious.article.service.ArticleService;

@Controller
public class ArticleController {
	
	
	ArticleService articleService;
	HttpSession session;
	
	public ArticleController(ArticleService articleService, HttpSession session) {
		this.articleService = articleService;
		this.session = session;
	}

	@ResponseBody
	@RequestMapping(path = "/imgArticle", consumes = "multipart/form-data", method = RequestMethod.POST)
	public Map<String, String> imgArticle(@RequestPart("upload") MultipartFile file, HttpServletRequest request) {
//		System.out.println("輸出測試");
//		System.out.println("file測試：" + file.getOriginalFilename());

		return new Attachment().ckEditorUploadImage(file, request);
	}
	
	@PostMapping("/postarticle.controller")
	public void postArticle(@RequestBody Map<String, String> params, HttpSession session) {

//		System.out.println(params);
//		System.out.println(params.get("article"));
//		System.out.println(params.get("classify"));
		Long id = (Long) session.getAttribute("userID");
//		System.out.println(articleEMDaoService.findAll());
//		System.out.println(id);
		articleService.pushArticle(params, id);
	}

	@ResponseBody
	@GetMapping("/totalRecipeData")
	public Map<String, Object> totalRecipeData() {
		Map<String, Object> data = new HashMap<>();
		data.put("session", session.getAttribute("userID"));
		data.put("title", articleService.findRecipe());
		return data;			
	}
	@ResponseBody
	@GetMapping("/totalKitchenwareData")
	public Map<String, Object> totalKitchenwareData() {
		Map<String, Object> data = new HashMap<>();
		data.put("session", session.getAttribute("userID"));
		data.put("title", articleService.findKitchenware());
		return data;
	}
	@ResponseBody
	@GetMapping("/totalArticleData")
	public Map<String, Object> totalArticleData() {
		Map<String, Object> data = new HashMap<>();
		data.put("session", session.getAttribute("userID"));
		data.put("title", articleService.findAll());
		return data;
	}
	
	@ResponseBody
	@GetMapping("/responseArticle")
	public Map<String, Object> useIdFinfAll(){
		int id = (int) session.getAttribute("ArticleId");
		//System.out.println("ArticleId2：　" + id);
		Map<String, Object> data = new HashMap<>();
		data.put("LoginId", session.getAttribute("userID"));
		data.put("title", articleService.useIdFindShareArea(id));
		data.put("article", articleService.useIdFindArticleArea(id));
		
		
		return data;		
	}
	//儲存ArticleId
	@GetMapping("/intIDFindAll/{id}")
	public String goSpecifyArticle(@PathVariable(value = "id", required = false) Integer id) {
		session.setAttribute("ArticleId", id);
		System.out.println("ArticleId：　" + id);
		return "app.ShowAtricle";
	}
	
	@DeleteMapping("/deleteData/{id}")
	public String deleteAtricle(@PathVariable(value="id", required = false ) Integer id) {
		System.out.println(id);
		articleService.useArticleIdDelete(id);
		//forward:/members
		
		//return目前失敗 要找em有沒有forward類似技術
		return "app.goShareArea";
	}
	
//	@PostMapping("/takeArticleData")
//	public void takeArticleData(@RequestBody Map<String, String> params) {
//
//		
//		//return "app.UpdateArticle";
//	}
	@GetMapping("/goUpdatePage")
	public String goUpdatePage(Model model) {
		int id = (int) session.getAttribute("ArticleId");
		model.addAttribute("LoginId", session.getAttribute("userID"));
		model.addAttribute("title", articleService.useIdFindShareArea(id));
		model.addAttribute("article", articleService.useIdFindArticleArea(id));
		model.addAttribute("article", articleService.useIdFindArticleArea(id));
		
		return "app.UpdateArticle";
	}
	
	@PostMapping("/articleUpdate")
	public void updateArticle(@RequestBody Map<String, String> params, HttpSession session) {
		int id = (int) session.getAttribute("ArticleId");
		System.out.println("article："+params.get("article"));
		articleService.UpdateArticle(params, id);
	}
}
