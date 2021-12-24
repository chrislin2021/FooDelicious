package foodelicious.product.model;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	private final static int PAGESIZE = 9;

	@Resource
	private ProductDao productDao;
	
	public Page<Product> getPage(int pageNumber) {
		PageRequest request = PageRequest.of(pageNumber - 1, PAGESIZE, Sort.Direction.DESC, "product_id");
		// 從第幾頁開始,每一頁幾筆資料(常數),順序(由大排到小),根據Entity哪個屬性的順序
		return productDao.findAll(request);
	}
}