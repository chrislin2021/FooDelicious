package foodelicious.CustomerService.model;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceService {
	public List<CustomerService> getCustService() {
		return List.of(new CustomerService());
	} 
}
