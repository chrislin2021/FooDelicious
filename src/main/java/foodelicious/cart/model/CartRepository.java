package foodelicious.cart.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartBean, Long> {

	List<CartBean> findAllByMemberId(Long memberId);

}