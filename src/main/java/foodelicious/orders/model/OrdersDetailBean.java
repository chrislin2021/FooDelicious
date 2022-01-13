package foodelicious.orders.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import foodelicious.member.model.Member;
import foodelicious.product.model.Product;

@Entity
@Table(name = "orders_detail")
@Component
public class OrdersDetailBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ordersdetail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderDetailId;

	@Column(name = "orders_id")
	@Transient
	private Long orderId;

	@Column(name = "member_id")
	@Transient
	private Long memberId;

	@Column(name = "product_id")
	@Transient
	private Long productId;

	@Column(name = "quantity")
	private Integer quantity;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "orders_id")
	private OrdersBean ordersBean;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id")
	private Member member;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;

	public OrdersDetailBean() {
		super();
	}

	public OrdersDetailBean(Long orderDetailId, Long orderId, Long memberId, Long productId, Integer quantity,
			OrdersBean ordersBean, Member member, Product product) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.memberId = memberId;
		this.productId = productId;
		this.quantity = quantity;
		this.ordersBean = ordersBean;
		this.member = member;
		this.product = product;
	}

	public Long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public OrdersBean getOrdersBean() {
		return ordersBean;
	}

	public void setOrdersBean(OrdersBean ordersBean) {
		this.ordersBean = ordersBean;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
