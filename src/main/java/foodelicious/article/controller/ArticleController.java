package foodelicious.article.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import foodelicious.article.model.ShareArea;
import foodelicious.article.service.ArticleUseEMDaoService;

@Controller
public class ArticleController {
	
	@Autowired
	public ArticleUseEMDaoService articleEMDaoService;
	
	

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
		articleEMDaoService.pushArticle(params, id);
	}

	@ResponseBody
	@GetMapping("/totalArticleData")
	public Map<String, Object> totalArticleData(HttpSession session) {
		Map<String, Object> data = new HashMap<>();
		data.put("session", session.getAttribute("userID"));
		data.put("title", articleEMDaoService.findAll());
		return data;			
	}
	
	@ResponseBody
	@GetMapping("/responseArticle")
	public Map<String, Object> useIdFinfAll(HttpSession session){
		int id = (int) session.getAttribute("ArticleId");
		//System.out.println("ArticleId2：　" + id);
		Map<String, Object> data = new HashMap<>();
		data.put("LoginId", session.getAttribute("userID"));
		data.put("title", articleEMDaoService.useIdFindShareArea(id));
		data.put("article", articleEMDaoService.useIdFindArticleArea(id));
		
		
		return data;		
	}
	//儲存ArticleId
	@GetMapping("/intIDFindAll/{id}")
	public String goSpecifyArticle(HttpSession session,@PathVariable(value = "id", required = false) Integer id) {
		session.setAttribute("ArticleId", id);
		System.out.println("ArticleId：　" + id);
		return "app.ShowAtricle";
	}
	//@ResponseBody
	//@RequestMapping(value = "/deleteData/{id}", method = RequestMethod.DELETE)
	@DeleteMapping("/deleteData/{id}")
	public String deleteAtricle(@PathVariable(value="id", required = false ) Integer id) {
		System.out.println(id);
		articleEMDaoService.useArticleIdDelete(id);
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
	public String goUpdatePage(HttpSession session, Model model) {
		int id = (int) session.getAttribute("ArticleId");
		model.addAttribute("LoginId", session.getAttribute("userID"));
		model.addAttribute("title", articleEMDaoService.useIdFindShareArea(id));
		model.addAttribute("article", articleEMDaoService.useIdFindArticleArea(id));
		model.addAttribute("article", articleEMDaoService.useIdFindArticleArea(id));
		return "app.UpdateArticle";
	}
	
	@PostMapping("/articleUpdate")
	public void updateArticle(@RequestBody Map<String, String> params, HttpSession session) {
		int id = (int) session.getAttribute("ArticleId");
		
		
		System.out.println("article："+params.get("article"));
		articleEMDaoService.UpdateArticle(params, id);
	}
}
