package foodelicious.custService.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer_service")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cstm_Id")
	private Long cstm_Id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendor_Id")
	private Long vendor_Id;

	@Column(name = "problem_Title")
	private String problem_Title;

	@Size(max = 500, message = "內容不得多於500個字唷")
	@Column(name = "problem_Text")
	private String problem_Text;

	@Column(name = "problem_postTime")
	private LocalDateTime problem_postTime;
	
	@Column(name="block_Img")
	private String block_Img;

}
