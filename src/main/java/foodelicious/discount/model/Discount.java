package foodelicious.discount.model;

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
@Table(name = "discount")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
