package foodelicious.compbackend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import foodelicious.member.model.Member;

@Entity
@Table(name="problem_report")
public class ProblemsBean implements Serializable {
	
	@Id
	@Column(name = "problem_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer problemId;
	
	@Column(name = "problem_category")
	private Integer problemCategory;
	
	@Column(name = "problem_content")
	private String problemContent;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "problem_submit_time")
	private Date problemSubmitDate;
	
	
	@Column(name = "problem_status")
	private String problemStatus;
	
	@Column(name = "company_id")
	private Long companyId;

	public Integer getProblemId() {
		return problemId;
	}

	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}

	public Integer getProblemCategory() {
		return problemCategory;
	}

	public void setProblemCategory(Integer problemCategory) {
		this.problemCategory = problemCategory;
	}

	public String getProblemContent() {
		return problemContent;
	}

	public void setProblemContent(String problemContent) {
		this.problemContent = problemContent;
	}

	public Date getProblemSubmitDate() {
		return problemSubmitDate;
	}

	public void setProblemSubmitDate(Date problemSubmitDate) {
		this.problemSubmitDate = problemSubmitDate;
	}

	public String getProblemStatus() {
		return problemStatus;
	}

	public void setProblemStatus(String problemStatus) {
		this.problemStatus = problemStatus;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	
	
	

}
