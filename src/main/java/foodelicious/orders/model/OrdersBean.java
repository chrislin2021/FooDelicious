package foodelicious.orders.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import foodelicious.member.model.Member;

@Entity
@Table(name = "orders")
public class OrdersBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orders_id")
	private Long ordersId;

	@Column(name = "member_id")
	private Long memberId;

	@Column(name = "orders_date")
	private LocalDateTime ordersDate;

	@Column(name = "orders_note")
	private String ordersNote;

	@Column(name = "orders_state")
	private String ordersState;

	@Column(name = "orders_total")
	private Integer ordersTotal;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id", insertable = false, updatable = false)
	private Member member;

	public OrdersBean() {
		super();
	}

	public OrdersBean(Long ordersId, Long memberId, LocalDateTime ordersDate, String ordersNote, String ordersState,
			Integer ordersTotal, Member member) {
		super();
		this.ordersId = ordersId;
		this.memberId = memberId;
		this.ordersDate = ordersDate;
		this.ordersNote = ordersNote;
		this.ordersState = ordersState;
		this.ordersTotal = ordersTotal;
		this.member = member;
	}

	public Long getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(Long ordersId) {
		this.ordersId = ordersId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public LocalDateTime getOrdersDate() {
		return ordersDate;
	}

	public void setOrdersDate(LocalDateTime ordersDate) {
		this.ordersDate = ordersDate;
	}

	public String getOrdersNote() {
		return ordersNote;
	}

	public void setOrdersNote(String ordersNote) {
		this.ordersNote = ordersNote;
	}

	public String getOrdersState() {
		return ordersState;
	}

	public void setOrdersState(String ordersState) {
		this.ordersState = ordersState;
	}

	public Integer getOrdersTotal() {
		return ordersTotal;
	}

	public void setOrdersTotal(Integer ordersTotal) {
		this.ordersTotal = ordersTotal;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
