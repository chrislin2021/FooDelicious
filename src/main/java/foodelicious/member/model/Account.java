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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

import foodelicious.article.model.ShareArea;

@Entity
@Table(name = "account_data")
@Component
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String Password_REG = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

	@Id
	@Column(name = "account_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long account_id;

	@NotBlank(message = "帳號不得空白")
	@Column(name = "account", unique = true)
	private String accountMake;

	@Pattern(regexp= Password_REG , message="請輸入至少8個字包含一個英文及數字")
	@Column(name = "pwd")
	private String pwd;

	@Column(name = "account_status", columnDefinition = "varchar(255) default 'normal'")
	private String account_status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "register_date")
	private Date register_date;

	@OneToOne(mappedBy = "account")
	private Member member;

	// 一對多 cascade負責處理連動
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
	private Set<ShareArea> shareAreas = new LinkedHashSet<ShareArea>();

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

	public Long getAccount_id() {
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
