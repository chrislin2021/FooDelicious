package foodelicious.CustomerService.model;

import org.springframework.stereotype.Repository;

import foodelicious.CustomerService.repository.CustomerServiceRepository;

@Repository
public class CustomerServiceDao implements CustomerServiceDaoInterface {

	public CustomerServiceDao(CustomerServiceRepository customerServiceRepository) {
		csrep = customerServiceRepository;
	}

	CustomerServiceRepository csrep;

	public boolean addProblem(CustomerService customerService) {
		var isSuccess = true;
		try {
			csrep.save(customerService);
		} catch (Exception e) {
			isSuccess = false;
		} 
		return isSuccess;
		
	}

}
