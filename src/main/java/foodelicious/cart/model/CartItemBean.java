package foodelicious.cart.model;

import java.io.Serializable;

import javax.annotation.Resource;

import foodelicious.product.model.Product;

public class CartItemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Resource
	private Product product;

	private Integer itemQuantity;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

}
