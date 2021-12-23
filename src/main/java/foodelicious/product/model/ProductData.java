package foodelicious.product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productData")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductData implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "product_id")
	private Long product_id;

	@Column(name = "product_pics")
	private Byte[] product_pics;

	@Column(name = "product_content")
	private String product_content;

	@Column(name = "product_keywords")
	private String product_keywords;

}
