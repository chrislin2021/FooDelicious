package foodelicious.product.model;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Resource
	private ProductDao productDao;
}
