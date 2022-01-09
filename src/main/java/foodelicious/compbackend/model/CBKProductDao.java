package foodelicious.compbackend.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import foodelicious.compbackend.repository.CBKProductRepository;
import foodelicious.product.model.Product;

@Repository
@Transactional
public class CBKProductDao implements CBKProductDaoInterface {

	@PersistenceContext
	EntityManager em;

	@Autowired
	private CBKProductRepository cbkProdRepository;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// 找到所有的商品
	public List<Product> getAllProducts(HttpSession session) {
		Long id = (Long) session.getAttribute("userID");
		List<Product> products = cbkProdRepository.findAllByProductCompanyId(id);
		return products;

	}
	
	@Override
	public Product findByProductId(Long productId) {
		
		return null;
	}


	public String updateProduct(Long productId, Product product) {
		Product newProduct = cbkProdRepository.findById(productId).orElse(null);
		if (newProduct != null) {
			newProduct.setProductName(product.getProductName());
			newProduct.setProductContent(product.getProductContent());
			newProduct.setProductPrice(product.getProductPrice());
			newProduct.setProductStatus(product.getProductStatus());
			newProduct.setProductStock(product.getProductStock());
			
			
			cbkProdRepository.save(newProduct);
			return "商品更新成功!!";
		} else {
			return "資料更新失敗，查無此筆資料";
		}
	}


	// 刪除商品 (好像跟某個table有衝突 無法刪除)
//	@Override
//	public String deleteProduct(Long productId) {
//		String sql = "DELETE FROM productNum WHERE product_id = :productId";
//		Map<String, Object> map = new HashMap<>();
//		map.put("productId", productId);
//		namedParameterJdbcTemplate.update(sql, map);
//		return "刪除資料成功";
//	}
	
	@Override
	public String deleteProduct(Integer id) {
		Product product = em.find(Product.class, id);
		em.remove(product);
		return "刪除成功吧";
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
