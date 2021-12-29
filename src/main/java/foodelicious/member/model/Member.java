package foodelicious.member.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity(name = "member_data")
@Table(name = "member_data")
@Component
public class Member implements Serializable {

	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int member_id;

<<<<<<< HEAD
	@Size(min = 2, max = 255, message = "名子不得低於兩個字")
=======
	@Size(min=2, max = 255, message = "名子不得低於兩個字")
>>>>>>> origin/master
	@Column(name = "member_name")
	private String userName;

	@Column(name = "member_gender")
	private String member_gender;

	//格式不確定這個是不是最佳的 要改
	@Column(name = "member_birth")
	private String member_birth;

	@Pattern(regexp = "^09[0-9]{8}$", message = "手機號碼格式有誤")
	@Column(name = "member_phone")
	private String member_phone;

	@Column(name = "member_address")
	private String member_address;

	@Column(name = "member_coin")
	private int member_coin;

	@Email
	@Column(name = "member_mail")
	private String userEmail;

	@Transient
	private int fk_account_id;

	@OneToOne(cascade = CascadeType.ALL)
<<<<<<< HEAD
	@JoinColumn(name = "fk_account_id", referencedColumnName = "account_id") //
=======
	@JoinColumn(name="fk_account_id", referencedColumnName = "account_id")//
>>>>>>> origin/master
	private Account account;


	public Member() {
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getMember_gender() {
		return member_gender;
	}


	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}


	public String getMember_birth() {
		return member_birth;
	}


	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}


	public String getMember_phone() {
		return member_phone;
	}


	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}


	public String getMember_address() {
		return member_address;
	}


	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}

<<<<<<< HEAD
=======

>>>>>>> origin/master
	public int getMember_coin() {
		return member_coin;
	}


	public void setMember_coin(int member_coin) {
		this.member_coin = member_coin;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
<<<<<<< HEAD
=======

>>>>>>> origin/master

	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public int getMember_id() {
		return member_id;
	}



}