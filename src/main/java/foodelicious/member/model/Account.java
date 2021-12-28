package foodelicious.member.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

import foodelicious.article.model.ShareArea;

@Entity(name="account_data")
@Table(name="account_data")
@Component
public class Account implements Serializable{

	@Id 
	@Column(name = "account_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int account_id;


	@NotBlank(message = "帳號不得空白")
	@Column(name = "account", unique = true)
	private String accountMake;

	@NotBlank(message = "密碼不得空白")
	@Column(name = "pwd")
	private String pwd;

	@Column(name = "account_status",columnDefinition = "varchar(255) default 'normal'")
	private String account_status;

	@Transient
	@Column(name = "register_date")
	private Date register_date;

	@OneToOne(mappedBy = "account")
	private Member member;

	public Account() {
	}

	public String getAccountMake() {
		return accountMake;
	}

	public void setAccountMake(String accountMake) {
		this.accountMake = accountMake;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAccount_status() {
		return account_status;
	}

	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getAccount_id() {
		return account_id;
	}

	public Date getRegister_date() {
		return register_date;
	}

	public Account(@NotBlank(message = "帳號不得空白") String accountMake, @NotBlank(message = "密碼不得空白") String pwd) {
		super();
		this.accountMake = accountMake;
		this.pwd = pwd;
	}


}