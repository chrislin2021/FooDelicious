package foodelicious.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodelicious.cart.model.CartBean;

@Repository
public interface CartRepository extends JpaRepository<CartBean, Long> {

	List<CartBean> findAllByMemberId(Long memberId);

}