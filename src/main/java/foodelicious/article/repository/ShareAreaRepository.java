package foodelicious.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodelicious.article.model.ShareArea;
@Repository
public interface ShareAreaRepository extends JpaRepository<ShareArea, Long> {

}
