package foodelicious.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodelicious.cart.model.CartBean;

@Repository
public interface CartRepository extends JpaRepository<CartBean, Long> {

//	JPA自定義方法不能有底線把底線去除
	List<CartBean> findAllByMemberId(Long memberId);

}