package foodelicious.CustomerService.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodelicious.CustomerService.model.CustomerService;
import foodelicious.CustomerService.model.CustomerServiceDao;
import foodelicious.CustomerService.model.CustomerServiceDaoInterface;
import foodelicious.CustomerService.repository.CustomerServiceRepository;

@Service // 商業邏輯的開發
@Transactional
public class CustomerService_Service implements CustomerService_ServiceImpl{
	
	@Autowired
	private CustomerServiceDaoInterface customerServiceDao;
	
	public CustomerService_Service() {
//		this.customerServiceRepository = customerServiceRepository;
	}
	
	public boolean addProblem(CustomerService customerService) {
		var answer = customerServiceDao.addProblem(customerService);
		return answer;
	}	


}
