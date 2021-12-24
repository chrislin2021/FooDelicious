package foodelicious.cart.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodelicious.member.model.Member;

@Repository
public interface CartDao extends JpaRepository<Cart, Long> {

	List<Cart> findByMember(Member member);
}