package foodelicious.CustomerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodelicious.CustomerService.model.CustomerService;

@Repository
public interface CustomerServiceRepository extends JpaRepository<CustomerService, Long>{

	void save(CustomerServiceRepository customerService);

}
