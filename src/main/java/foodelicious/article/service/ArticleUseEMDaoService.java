package foodelicious.article.service;

import java.util.List;
import java.util.Map;

import foodelicious.article.model.ShareArea;


public interface ArticleUseEMDaoService {	
	
	public void pushArticle(Map<String, String> params, Long id) ;
	
	public List<ShareArea> findAll();
}
