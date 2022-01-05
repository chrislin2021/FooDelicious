package foodelicious.CustomerService.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodelicious.CustomerService.model.CustomerService;
import foodelicious.CustomerService.repository.CustomerServiceRepository;

@Service // 商業邏輯的開發
@Transactional
public class CustomerService_Service {

	private final CustomerServiceRepository customerServiceRepository;

	public CustomerService_Service(CustomerServiceRepository customerServiceRepository) {
		this.customerServiceRepository = customerServiceRepository;
	}
	
//	public CustomerServiceRepository save(CustomerServiceRepository CustomerService) {
//		return CustomerServiceRepository.save(CustomerService);
//	}

}
