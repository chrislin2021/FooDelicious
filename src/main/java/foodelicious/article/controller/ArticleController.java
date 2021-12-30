package foodelicious.article.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

		System.out.println(params);
		System.out.println(params.get("article"));
		System.out.println(params.get("classify"));
		Long id = (Long) session.getAttribute("userID");
		System.out.println(articleEMDaoService.findAll());
		System.out.println(id);
		articleEMDaoService.pushArticle(params, id);
	}
	
	@GetMapping("/totalArticleData")
	public ModelAndView totalArticleData(ModelAndView mav) {
		mav.getModel().put("TotalData", articleEMDaoService.findAll());
		mav.setViewName("app.ShareArea");
		return mav;
	}
}
