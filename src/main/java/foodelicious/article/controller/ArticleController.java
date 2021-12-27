package foodelicious.article.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ArticleController {

	@ResponseBody
	@RequestMapping(path = "/imgArticle", consumes = "multipart/form-data",method = RequestMethod.POST)
	public String imgArticle(@RequestPart("upload") MultipartFile file) {
		System.out.println("輸出測試");
		System.out.println("file測試："+file);

		return "111";
	}
}
