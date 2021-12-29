package foodelicious.article.model;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShareAreaDAO extends PagingAndSortingRepository<ShareArea, Long> {
	ShareArea findFirstByOrderByAddedDesc();
}
