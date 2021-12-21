package foodelicious.article.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {

	@ResponseBody
	@PostMapping("/imgArticle")
	public String imgArticle(@RequestBody Map<String, String> params) {
		
		System.out.println(params);
		System.out.println("輸出測試");
		return "輸出測試";
	}
}
