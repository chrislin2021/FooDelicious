package foodelicious.product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productNum")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer product_id;

	@Column(name = "categories")
	private Short product_categories;

	@Column(name = "product_name")
	private String product_name;

	@Column(name = "product_stock")
	private String product_stock;

	@Column(name = "product_sales_figures")
	private Integer product_sales_figures;

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Short getProduct_categories() {
		return product_categories;
	}

	public void setProduct_categories(Short product_categories) {
		this.product_categories = product_categories;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_stock() {
		return product_stock;
	}

	public void setProduct_stock(String product_stock) {
		this.product_stock = product_stock;
	}

	public Integer getProduct_sales_figures() {
		return product_sales_figures;
	}

	public void setProduct_sales_figures(Integer product_sales_figures) {
		this.product_sales_figures = product_sales_figures;
	}

}
