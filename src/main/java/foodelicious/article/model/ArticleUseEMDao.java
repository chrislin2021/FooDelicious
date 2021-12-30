package foodelicious.article.model;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import foodelicious.member.model.Account;

@Repository
@Transactional
public class ArticleUseEMDao {
	
	@PersistenceContext
	EntityManager em;
	
//	EntityManager
//	private static ArticleDAO articleDAO;
	
	public void pushArticle(Map<String, String> params, Long id) {
		//用session.get的方法 用id 去找到對應的Account.class 並且將其命名為 account 參數
		Account account = em.find(Account.class, id);

//		System.out.println("一對多測試：" + account.getAccount_id());
		
		//ArticleData與 ShareArea的關係是「一對一」ArticleData(外來鍵)與 ShareArea(主鍵)
		ArticleData articleData = new ArticleData();
		articleData.setArticle(params.get("article"));
		
		
		ShareArea shareArea = new ShareArea();
		shareArea.setArticle_clallify(params.get("classify"));
		shareArea.setArticle_title(params.get("title"));
//		shareArea.setFk_account_id(id);
		
		//Account 與 ShareArea 的關係是一對多
		//在ArticleData與 ShareArea資料傳輸給SQL前 還要設定好一對多的部分 
		shareArea.setAccount(account);
		
		//ShareArea 與 Account的關係明確後 最後再與ArticleData的關係做明確的設定
		articleData.setShareArea(shareArea);
		
		//儲存
		em.persist(articleData);
		em.close();
	}
//	@PostConstruct
//	public void init() {
//		articleDAO = this;
//		articleDAO.sessionFactory = this.sessionFactory;
//	}
	
}
