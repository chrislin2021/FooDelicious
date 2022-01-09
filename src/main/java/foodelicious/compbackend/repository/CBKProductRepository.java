package foodelicious.compbackend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import foodelicious.orders.model.OrdersBean;
import foodelicious.product.model.Product;

@Repository
public interface CBKProductRepository extends JpaRepository<Product, Long>{

	List<Product> findAllByProductCompanyId(Long companyId);
	
	Product findByProductId(Integer productId);
	

	


}
