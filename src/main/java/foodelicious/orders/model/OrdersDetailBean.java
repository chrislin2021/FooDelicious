package foodelicious.orders.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "orders_detail")
@Component
public class OrdersDetailBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ordersDetail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ordersDetailId;

	@Column(name = "orders_id")
	private Long ordersId;

	@Column(name = "productDetail")
	private String productDetail;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "orders_id", insertable = false, updatable = false)
	private OrdersBean ordersBean;

	public OrdersDetailBean() {
		super();
	}

	public OrdersDetailBean(Long ordersDetailId, Long ordersId, String productDetail, OrdersBean ordersBean) {
		super();
		this.ordersDetailId = ordersDetailId;
		this.ordersId = ordersId;
		this.productDetail = productDetail;
		this.ordersBean = ordersBean;
	}

	public Long getOrdersDetailId() {
		return ordersDetailId;
	}

	public void setOrdersDetailId(Long ordersDetailId) {
		this.ordersDetailId = ordersDetailId;
	}

	public Long getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(Long ordersId) {
		this.ordersId = ordersId;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public OrdersBean getOrdersBean() {
		return ordersBean;
	}

	public void setOrdersBean(OrdersBean ordersBean) {
		this.ordersBean = ordersBean;
	}

}
