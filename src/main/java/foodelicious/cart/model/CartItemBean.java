package foodelicious.cart.model;

import java.io.Serializable;

import javax.annotation.Resource;

import foodelicious.product.model.Product;

public class CartItemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Resource
	private Product product;

	private Integer Quantity;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

}
