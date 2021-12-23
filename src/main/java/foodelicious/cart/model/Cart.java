package foodelicious.cart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import foodelicious.member.model.Member;
import foodelicious.product.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shopping_cart")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Long cart_id;

	@OneToOne
	@JoinColumn(name = "member_id")
	private Member member_id;

	@ManyToMany
	@JoinColumn(name = "product_id")
	private Product product_id;

	@Column(name = "cart_quantity")
	private Integer cart_quantity;
}
