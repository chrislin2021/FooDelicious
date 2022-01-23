package foodelicious.CustomerService.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<CustomerService> queryProblem(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        
        CriteriaQuery<CustomerService> cq = cb.createQuery(CustomerService.class); 

        Root<CustomerService> root = cq.from(CustomerService.class); 

        Predicate predEmail = cb.equal(root.get("cstm_email"), email);
        cq.where(predEmail); 

        TypedQuery<CustomerService> tq = em.createQuery(cq);
        return tq.getResultList();
	}

	public boolean updateProblem(CustomerService customerService) {
		var isSuccess = true;
		try {
			csrep.save(customerService);
		} catch (Exception e) {
			isSuccess = false;
		} 
		return isSuccess;
	}

	@Override
	public boolean deleteProblem(Long Id) {
		var isSuccess = true;
		try {
			csrep.deleteById(Id);
		} catch (Exception e) {
			isSuccess = false;
		}
		return isSuccess;
	}

}
