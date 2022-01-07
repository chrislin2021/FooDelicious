package foodelicious.compbackend.model;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import foodelicious.compbackend.repository.CBKProductRepository;
import foodelicious.member.model.Member;
import foodelicious.product.model.Product;



@Repository
@Transactional
public class CBKProductDao implements CBKProductDaoInterface{
	
	@PersistenceContext
	EntityManager em;

	@Autowired
	private CBKProductRepository cbkProdRepository;
	
	public List<Product> getAllProducts(HttpSession session) {
		Long id = (Long) session.getAttribute("userID");
		List<Product> products = cbkProdRepository.findAllByProductCompanyId(id);
		return products;
		
	}

	
	
//	public List<Product> getAllProducts(Long id,HttpSession session){
//		Query query = null;
//		id = (Long)session.getAttribute("userID");
//		System.out.println(id);
//		//Long 轉換 int
//		String hqlstr = "FROM Product WHERE product_company_id=?1";
//		System.out.println(hqlstr);
//		query = em.createQuery(hqlstr)
//			    .setParameter("1", id);
//		
//		List<Product> productData = query.getResultList();
//		System.out.println(productData);
//		em.close();
//		
//		if(productData != null) {
//			
//			return productData;
//		}
//				
//
//		return null;
//	}




	







	
	
	
	


	
	

}
