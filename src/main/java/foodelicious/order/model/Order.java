package foodelicious.order.model;

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
@Table(name = "order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long order_id;

//	建立與會員的關係
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id")
	private Member member_id;

	@Column(name = "order_note")
	private String order_note;

	@Column(name = "order_date")
	private LocalDateTime order_date;

	@Column(name = "order_total")
	private Integer order_total;

	@Column(name = "order_state")
	private String order_state;

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Member getMember() {
		return member_id;
	}

	public void setMember(Member member_id) {
		this.member_id = member_id;
	}

	public String getOrder_note() {
		return order_note;
	}

	public void setOrder_note(String order_note) {
		this.order_note = order_note;
	}

	public LocalDateTime getOrder_date() {
		return order_date;
	}

	public void setOrder_date(LocalDateTime order_date) {
		this.order_date = order_date;
	}

	public Integer getOrder_total() {
		return order_total;
	}

	public void setOrder_total(Integer order_total) {
		this.order_total = order_total;
	}

	public String getOrder_state() {
		return order_state;
	}

	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}

}
