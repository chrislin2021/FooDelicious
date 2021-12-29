package foodelicious.article.model;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

//import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import foodelicious.member.model.Account;

@Repository
@Transactional
public class ArticleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
//	private static ArticleDAO articleDAO;
	
	public void pushArticle(Map<String, String> params, Long id) {
		Session session = sessionFactory.openSession();
		
		Account account = session.get(Account.class, id);


		System.out.println("一對多測試：" + account.getAccount_id());
		ArticleData articleData = new ArticleData();
		articleData.setArticle(params.get("article"));
		
		
		
		ShareArea shareArea = new ShareArea();
		shareArea.setArticle_clallify(params.get("classify"));
		shareArea.setArticle_title(params.get("title"));
//		shareArea.setFk_account_id(id);
		
		Set<ShareArea> tempSet = new LinkedHashSet<ShareArea>();
		tempSet.add(shareArea);
		
		shareArea.setAccount(account);
		
		articleData.setShareArea(shareArea);
		
//		System.out.println(params);
//		System.out.println(id);
		session.save(articleData);
		session.close();
	}
//	@PostConstruct
//	public void init() {
//		articleDAO = this;
//		articleDAO.sessionFactory = this.sessionFactory;
//	}
	
}
