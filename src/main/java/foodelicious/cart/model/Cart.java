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
	private Member member_id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product_id;

	@Column(name = "cart_quantity")
	private Integer cart_quantity;

	@Column(name = "cart_total")
	private Integer cart_total;

	public Long getCart_id() {
		return cart_id;
	}

	public void setCart_id(Long cart_id) {
		this.cart_id = cart_id;
	}

	public Member getMember_id() {
		return member_id;
	}

	public void setMember_id(Member member_id) {
		this.member_id = member_id;
	}

	public Product getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Product product_id) {
		this.product_id = product_id;
	}

	public Integer getCart_quantity() {
		return cart_quantity;
	}

	public void setCart_quantity(Integer cart_quantity) {
		this.cart_quantity = cart_quantity;
	}

	public Integer getCart_total() {
		return cart_total;
	}

	public void setCart_total(Integer cart_total) {
		this.cart_total = cart_total;
	}

}
