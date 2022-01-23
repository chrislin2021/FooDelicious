package foodelicious.CustomerService.service;

import java.util.List;

import foodelicious.CustomerService.model.CustomerService;

public interface CustomerService_ServiceImpl{
	
	boolean addProblem(CustomerService customerService);

	public List<CustomerService> queryProblem(String email);

	boolean deleteProblem(Long Id);

	boolean updateProblem(CustomerService customerService);
	

}
