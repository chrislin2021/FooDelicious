package foodelicious.discount.model;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class DiscountService {

	@Resource
	private DiscountDao discountDao;
}
