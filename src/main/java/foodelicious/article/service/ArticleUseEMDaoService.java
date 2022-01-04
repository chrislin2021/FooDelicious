package foodelicious.article.service;

import java.util.List;
import java.util.Map;

import foodelicious.article.model.ArticleData;
import foodelicious.article.model.ShareArea;


public interface ArticleUseEMDaoService {	
	
	public void pushArticle(Map<String, String> params, Long id) ;
	
	public List<ShareArea> findAll();

	List<ShareArea> useIdFindShareArea(int id);

	List<ArticleData> useIdFindArticleArea(int id);
	
	void useArticleIdDelete(int id);
	
	void UpdateArticle(Map<String, String> params ,int id);

	List<ShareArea> findRecipe();
	
	List<ShareArea> findKitchenware();
}
