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

import foodelicious.backend.productPage.model.BkProduct;
import foodelicious.compbackend.repository.CBKProductRepository;
import foodelicious.product.model.Product;

@Repository
@Transactional
public class CBKProductDao implements CBKProductDaoInterface {

	@PersistenceContext
	EntityManager em;

	private CBKProductRepository cbkProdRepository;

	public CBKProductDao(final CBKProductRepository cbkProdRepository) {
		this.cbkProdRepository = cbkProdRepository;
	}

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// 找到所有的商品
	@Override
	public List<Product> getAllProducts(HttpSession session) {
		Long id = (Long) session.getAttribute("userID");
		List<Product> products = cbkProdRepository.findAllByProductCompanyId(id);
		return products;

	}

	// 刪除商品
	@Override
	public String deleteProduct(Long productId) {
		Product product = em.find(Product.class, productId);
		if (product != null) {
			em.remove(product);
			return "Product deletion successful!";
		} else {
			return "Product not found. Please try again.";
		}

	}

	// 商品id
	@Override
	public Product findByProductId(Long productId) {
		Product product = em.find(Product.class, productId);
		return product;
	}

	// 更新商品
	@Override
	public String updateProduct(Long productId, Product product) {
		Product newProduct = cbkProdRepository.findByProductId(productId);
		if (newProduct != null) {
			newProduct.setProductCompany(product.getProductCompany());
			newProduct.setProductName(product.getProductName());
			newProduct.setProductCategories_name(newProduct.getProductCategories_name());
			newProduct.setProductCategories(product.getProductCategories());
			newProduct.setProductPrice(product.getProductPrice());
			newProduct.setProductContent(product.getProductContent());
			newProduct.setProductStock(product.getProductStock());
			newProduct.setProductStatus(product.getProductStatus());
			newProduct.setProductKeywords(product.getProductKeywords());
			cbkProdRepository.save(newProduct);
			return "商品更新成功!";
		} else {

			return "商品更新失敗。請重新再試一次。";
		}

	}

	// 分類找到商品
	@Override
	public List<Product> findByType(Integer category, Long productCompanyId) {
		List<Product> catProd = cbkProdRepository.findByType(category, productCompanyId);
		return catProd;
	}

	// 名字
	@Override
	public List<Product> findByName(String productName) {

		List<Product> products = cbkProdRepository.findByName(productName);

		return products;
	}

	// 名字跟分類
	@Override
	public List<Product> findByNameAndType(String productName, Integer categories, Long productCompanyId) {
		List<Product> products = cbkProdRepository.findByNameAndType(productName, categories, productCompanyId);
		return products;
	}
	// insert商品
	@Override
	public boolean saveProduct(Product product) {
		Product theSavedProduct = cbkProdRepository.save(product);
		if (theSavedProduct != null) {
			return true;
		} else {
			return false;
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
