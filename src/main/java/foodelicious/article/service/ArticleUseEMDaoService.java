package foodelicious.article.service;

import java.util.List;
import java.util.Map;

//import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
//import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import foodelicious.article.dao.ArticleUseEMDao;
import foodelicious.article.model.ShareArea;

public interface ArticleUseEMDaoService {	
	
	public void pushArticle(Map<String, String> params, Long id) ;
	
	public List<ShareArea> findAll();
}
