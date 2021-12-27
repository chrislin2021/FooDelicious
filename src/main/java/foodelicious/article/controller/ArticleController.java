package foodelicious.article.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {

	@ResponseBody
	@RequestMapping(path = "/imgArticle", consumes = "multipart/form-data",method = RequestMethod.POST)
	public String imgArticle(@RequestBody() Map<String, String> test) {
		System.out.println("輸出測試");
		System.out.println(test);

		return "111";
	}
}
