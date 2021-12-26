package foodelicious.cart.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import foodelicious.member.model.Member;
import foodelicious.product.model.Product;

@Entity
@Table(name = "shopping_cart")
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Long cart_id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id")
	private Member member;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product_id;

	@Column(name = "cart_quantity")
	private Integer product_quantity;

	@Column(name = "cart_unitPrice")
	private Integer product_unitPrice;

	@Column(name = "cart_totalPrice")
	private Integer cart_totalPrice;

	public Long getCart_id() {
		return cart_id;
	}

	public void setCart_id(Long cart_id) {
		this.cart_id = cart_id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Product getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Product product_id) {
		this.product_id = product_id;
	}

	public Integer getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}

	public Integer getProduct_unitPrice() {
		return product_unitPrice;
	}

	public void setProduct_unitPrice(Integer product_unitPrice) {
		this.product_unitPrice = product_unitPrice;
	}

	public Integer getCart_totalPrice() {
		return cart_totalPrice;
	}

	public void setCart_totalPrice(Integer cart_totalPrice) {
		this.cart_totalPrice = cart_totalPrice;
	}

}
