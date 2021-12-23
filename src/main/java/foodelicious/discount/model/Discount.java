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
public class Discount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "discount_id")
	private Long discount_id;

	@Column(name = "discount_name")
	private String discount_name;

	@Column(name = "discount_content")
	private String discount_content;

	public Long getDiscount_id() {
		return discount_id;
	}

	public void setDiscount_id(Long discount_id) {
		this.discount_id = discount_id;
	}

	public String getDiscount_name() {
		return discount_name;
	}

	public void setDiscount_name(String discount_name) {
		this.discount_name = discount_name;
	}

	public String getDiscount_content() {
		return discount_content;
	}

	public void setDiscount_content(String discount_content) {
		this.discount_content = discount_content;
	}

}
