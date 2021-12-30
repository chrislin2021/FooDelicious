package foodelicious.article.model;

import java.util.Map;

//import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
public class ArticleUseEMDaoService {
	
	@Autowired
	private ArticleUseEMDao articleUseEMDao;
	
//	private static ArticleDAOService articleDAOService;
	
	public void pushArticle(Map<String, String> params, Long id) {
		articleUseEMDao.pushArticle(params, id);
	}
	
//	@PostConstruct
//	public void init() {
//		articleDAOService = this;
//		articleDAOService.articleDAO = this.articleDAO;
//	}
}
