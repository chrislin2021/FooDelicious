package foodelicious.article.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import foodelicious.article.model.ShareArea;


public interface ShareAreaCrudRepository extends CrudRepository<ShareArea, Long> {

	@Query(value="SELECT * FROM share_area WHERE article_clallify = ? AND article_title LIKE %?%", nativeQuery = true)
	List<ShareArea> findByAssociateString(String clallify, String AssociateString);
}
