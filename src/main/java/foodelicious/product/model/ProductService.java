package foodelicious.product.model;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	//查詢
	public List<Product> findAll() {
		return productDao.findAll();
	}
	
	public List<Product> findByProductId(Integer productId) {
		return productDao.findByProductId(productId);
	}
	
	public Product findByProductName(String productName) {
		return productDao.findByProductName(productName);
	}

	//刪除
	public void deleteByProductId(Integer productId) {
		productDao.deleteByProductId(productId);
	}
	//新增
	public void saveProduct(Product product) {
		 this.productDao.save(product);
	}

	
}