package foodelicious.product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productNum")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long product_id;

	@Column(name = "categories")
	private Short product_categories;

	@Column(name = "product_name")
	private String product_name;

	@Column(name = "product_stock")
	private String product_stock;

	@Column(name = "product_sales_figures")
	private Integer product_sales_figures;

}
