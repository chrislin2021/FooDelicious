package foodelicious.CustomerService.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "customer_service")
public class CustomerService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long Id;
	
	@NotBlank(message="姓名不可為空白")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cstm_Id")
	private Long cstm_Id;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendor_Id")
	private Long vendor_Id;
	
	@NotBlank(message="標題不可為空白")
	@Column(name = "problem_Title")
	private String problem_Title;

	@NotBlank(message="內容不可為空白")
	@Size(max = 500, message = "內容不得多於500個字")
	@Column(name = "problem_Text")
	private String problem_Text;
	
	@Column(name = "problem_postTime")
	private LocalDateTime problem_postTime;
	
	@Column(name="block_Img")
	private String block_Img;
	
	public CustomerService() {
	}
	
	public CustomerService(String problem_Title) {
		this.problem_Title = problem_Title;
	}
	
	public CustomerService(@NotBlank(message = "標題不可為空白") String problem_Title,
			@NotBlank(message = "內容不可為空白") @Size(max = 500, message = "內容不得多於500個字") String problem_Text,
			LocalDateTime problem_postTime, String block_Img) {
		super();
		this.problem_Title = problem_Title;
		this.problem_Text = problem_Text;
		this.problem_postTime = problem_postTime;
		this.block_Img = block_Img;
	}

	public Long getCstm_Id() {
		return cstm_Id;
	}

	public void setCstm_Id(Long cstm_Id) {
		this.cstm_Id = cstm_Id;
	}

	public Long getVendor_Id() {
		return vendor_Id;
	}

	public void setVendor_Id(Long vendor_Id) {
		this.vendor_Id = vendor_Id;
	}

	public String getProblem_Title() {
		return problem_Title;
	}

	public void setProblem_Title(String problem_Title) {
		this.problem_Title = problem_Title;
	}

	public String getProblem_Text() {
		return problem_Text;
	}

	public void setProblem_Text(String problem_Text) {
		this.problem_Text = problem_Text;
	}

	public LocalDateTime getProblem_postTime() {
		return problem_postTime;
	}

	public void setProblem_postTime(LocalDateTime problem_postTime) {
		this.problem_postTime = problem_postTime;
	}

	public String getBlock_Img() {
		return block_Img;
	}

	public void setBlock_Img(String block_Img) {
		this.block_Img = block_Img;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
