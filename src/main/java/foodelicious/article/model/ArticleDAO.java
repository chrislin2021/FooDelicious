package foodelicious.article.model;

import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ArticleDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void pushArticle(Map<String, String> params, Long id) {
		Session session = sessionFactory.openSession();
		System.out.println(params);
		System.out.println(id);
		session.close();
	}
	
}
