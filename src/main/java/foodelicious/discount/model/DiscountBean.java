package foodelicious.discount.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "discount")
public class DiscountBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "discount_id")
	private Long discountId;

	@Column(name = "member_id")
	private Long memberId;

	@Column(name = "discount_name")
	private String discountName;

	@Column(name = "discount_content")
	private Integer discountContent;

	public DiscountBean() {
		super();
	}

	public DiscountBean(Long discountId, Long memberId, String discountName, Integer discountContent) {
		super();
		this.discountId = discountId;
		this.memberId = memberId;
		this.discountName = discountName;
		this.discountContent = discountContent;
	}

	public Long getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public Integer getDiscountContent() {
		return discountContent;
	}

	public void setDiscountContent(Integer discountContent) {
		this.discountContent = discountContent;
	}

}
