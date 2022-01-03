package foodelicious.product.model;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public List<Product> findAll() {
		return productDao.findAll();
	}
	
	public Product findByProductId(Integer productId) {
		return productDao.findByProductId(productId);
	}
	
	public Product AddAndEdit(Product product) {
		return productDao.save(product);
	}

	public void DeleteById(Integer productId) {
		productDao.deleteById(productId);
	}

//	public void saveProduct(Product product) {
//		this.productDao.save(product);
//	}
}