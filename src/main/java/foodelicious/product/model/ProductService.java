package foodelicious.product.model;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	//查詢
	public Page<Product> findAll() {
		Pageable pageble = PageRequest.of(0, 9);
		return productDao.findAll(pageble);
	}
	
	public List<Product> findByProductId(Long productId) {
		return productDao.findByProductId(productId);
	}
	
	public Product findByProductName(String productName) {
		return productDao.findByProductName(productName);
	}

	//刪除
	public void deleteByProductId(Long productId) {
		productDao.deleteByProductId(productId);
	}
	//新增
	public void saveProduct(Product product) {
		 this.productDao.save(product);
	}

	
}