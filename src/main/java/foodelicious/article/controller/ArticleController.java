package foodelicious.article.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import foodelicious.article.model.ShareArea;
import foodelicious.article.service.ArticleService;

@Controller
public class ArticleController {
	
	
	ArticleService articleService;
	HttpSession session;
	
	public ArticleController(ArticleService articleService, HttpSession session) {
		this.articleService = articleService;
		this.session = session;
	}
	//圖像綁定使用 用於CKEditor
	@ResponseBody
	@RequestMapping(path = "/imgArticle", consumes = "multipart/form-data", method = RequestMethod.POST)
	public Map<String, String> imgArticle(@RequestPart("upload") MultipartFile file, HttpServletRequest request) {
//		System.out.println("輸出測試");
//		System.out.println("file測試：" + file.getOriginalFilename());

		return new Attachment().ckEditorUploadImage(file, request);
	}
	
	//新增文章 儲存用
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
	//所有食譜相關
	@ResponseBody
	@GetMapping("/totalRecipeData")
	public Map<String, Object> totalRecipeData() {
		Map<String, Object> data = new HashMap<>();
		data.put("session", session.getAttribute("userID"));
		data.put("title", articleService.findRecipe());
		return data;			
	}
	//所有廚具相關
	@ResponseBody
	@GetMapping("/totalKitchenwareData")
	public Map<String, Object> totalKitchenwareData() {
		Map<String, Object> data = new HashMap<>();
		data.put("session", session.getAttribute("userID"));
		data.put("title", articleService.findKitchenware());
		return data;
	}
	
	//顯示所有文章
	@ResponseBody
	@GetMapping("/totalArticleData")
	public Map<String, Object> totalArticleData() {
		Map<String, Object> data = new HashMap<>();
		data.put("session", session.getAttribute("userID"));
		data.put("title", articleService.findAll());
		return data;
	}
	
	//使用id顯示文章所有內容
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
		//System.out.println("ArticleId：　" + id);
		return "app.ShowAtricle";
	}
	
	//透過id刪除文章
	@DeleteMapping("/deleteData/{id}")
	public void deleteAtricle(@PathVariable(value="id", required = false ) Integer id) {
		
		articleService.useArticleIdDelete(id);
		
		Map<String, Object> data = new HashMap<>();
		data.put("session", session.getAttribute("userID"));
		data.put("title", articleService.findAll());
	}

	//前往修改頁面 同時使用model 將資料轉移
	@GetMapping("/goUpdatePage")
	public String goUpdatePage(Model model) {
		int id = (int) session.getAttribute("ArticleId");
		model.addAttribute("LoginId", session.getAttribute("userID"));
		model.addAttribute("title", articleService.useIdFindShareArea(id));
		model.addAttribute("article", articleService.useIdFindArticleArea(id));
		model.addAttribute("article", articleService.useIdFindArticleArea(id));
		
		return "app.UpdateArticle";
	}
	
	//文章更新用
	@PutMapping("/articleUpdate/{id}")
	public void updateArticle(@RequestBody Map<String, String> params,
								@PathVariable("id")Integer shareId) {		
		articleService.UpdateArticle(params, shareId);
	}
	
	@ResponseBody
	@PostMapping("/fuzzySearch")
	public Map<String, Object> FuzzySearch(@RequestBody Map<String, String> params) {
		Map<String, Object> data = new HashMap<>();
		System.out.println("clasify："+params.get("clasify"));
		System.out.println("AssociateString："+params.get("AssociateString"));
		
		data.put("session", session.getAttribute("userID"));
		data.put("title", articleService.articleFuzzySearch(params.get("clasify"), params.get("AssociateString")));
		return data;
	}
	
}
