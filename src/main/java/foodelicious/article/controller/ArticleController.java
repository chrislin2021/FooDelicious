package foodelicious.article.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import foodelicious.article.model.Attachment;

@Controller
public class ArticleController {

	@ResponseBody
	@RequestMapping(path = "/imgArticle", consumes = "multipart/form-data", method = RequestMethod.POST)
	public Map<String, String> imgArticle(@RequestPart("upload") MultipartFile file, HttpServletRequest request) {
//		System.out.println("輸出測試");
//		System.out.println("file測試：" + file.getOriginalFilename());

		return new Attachment().ckEditorUploadImage(file, request);
	}
	
	@PostMapping("/postarticle.controller")
	public String postArticle(@RequestBody Map<String, String> params) {
		System.out.println(params);
		System.out.println(params.get("article"));
		System.out.println(params.get("classify"));
		
		return "app.ShareArea";
	}
}
