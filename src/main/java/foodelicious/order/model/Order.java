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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import foodelicious.discount.model.Discount;
import foodelicious.member.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_cart")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long order_id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToOne
	@Column(name = "discount_id")
	private Discount discount_id;

	@Column(name = "order_note")
	private String order_note;

	@Column(name = "order_date")
	private LocalDateTime order_date;

	@Column(name = "order_total")
	private Integer order_total;

	@Column(name = "order_state")
	private String order_state;

}
