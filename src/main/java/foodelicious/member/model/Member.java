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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import foodelicious.article.model.ShareArea;
import foodelicious.product.model.Product;

@Entity(name = "member_data2")
@Table(name = "member_data2")
@Component
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String PHONE_REG = "09[0-9]{8}$";
	public static final String PERSONID_REG = "^[A-Z]{1}[1-2]{1}[0-9]{8}$";
	public static final String Password_REG = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*\\W).{8,}$";
	public static final String NAME_REG = "^[\u4E00-\u9FA5]{2,}$";

	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;

	@Column(name = "member_mail", unique = true)
	@Email
	private String memberMail;

	@Column(name = "pwd")
	@Pattern(regexp = Password_REG, message = "請輸入至少8個字包含一個英文及數字")
	@NotBlank(message = "密碼不得空白")
	private String pwd;

	@Column(name = "member_name")
	@Pattern(regexp = NAME_REG, message = "請輸入2個字以上繁體中文")
	@Size(min = 2, max = 255, message = "名子不得低於兩個字")
	private String memberName;

	@Column(name = "member_gender")
	private String memberGender;

	@Column(name = "member_birth")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private String memberBirth;

	@Column(name = "member_phone")
	@Pattern(regexp = "^09[0-9]{8}$", message = "手機號碼格式有誤")
	private String memberPhone;

	@Column(name = "member_address")
	private String memberAddress;

	@Column(name = "member_discount_id")
	private String memberDiscountId;

	@Column(name = "member_coin")
	private Integer memberCoin;

	@Column(name = "member_status", columnDefinition = "varchar(255) default 'normal'")
	private String member_status;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "register_date")
	private Date register_date;

	// 與ShareArea是一對多關係
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.ALL)
	private Set<ShareArea> shareAreas = new LinkedHashSet<ShareArea>();

	
	//Join Product 的 table
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.ALL)
	private Set<Product> products = new LinkedHashSet<Product>();

	@PrePersist // 設定物件轉換為 Persistent 以前執行
	private void onCreate() {
		if (register_date == null) {
			register_date = new Date();
		}
	}

	public Member(String memberMail, String pwd) {
		this.memberMail = memberMail;
		this.pwd = pwd;
	}

	public Member() {

	}

	public Member(Long memberId, @Email String memberMail,
			@Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*\\W).{8,}$", message = "請輸入至少8個字包含一個英文及數字") @NotBlank(message = "密碼不得空白") String pwd,
			@Pattern(regexp = "^[一-龥]{2,}$", message = "請輸入2個字以上繁體中文") @Size(min = 2, max = 255, message = "名子不得低於兩個字") String memberName,
			String memberGender, String memberBirth,
			@Pattern(regexp = "^09[0-9]{8}$", message = "手機號碼格式有誤") String memberPhone, String memberAddress,
			String memberDiscountId, Integer memberCoin, String member_status, Date register_date) {
		super();
		this.memberId = memberId;
		this.memberMail = memberMail;
		this.pwd = pwd;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberBirth = memberBirth;
		this.memberPhone = memberPhone;
		this.memberAddress = memberAddress;
		this.memberDiscountId = memberDiscountId;
		this.memberCoin = memberCoin;
		this.member_status = member_status;
		this.register_date = register_date;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMemberMail() {
		return memberMail;
	}

	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberDiscountId() {
		return memberDiscountId;
	}

	public void setMemberDiscountId(String memberDiscountId) {
		this.memberDiscountId = memberDiscountId;
	}

	public Integer getMemberCoin() {
		return memberCoin;
	}

	public void setMemberCoin(Integer memberCoin) {
		this.memberCoin = memberCoin;
	}

	public String getMember_status() {
		return member_status;
	}

	public void setMember_status(String member_status) {
		this.member_status = member_status;
	}

	public Date getRegister_date() {
		return register_date;
	}

	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getPhoneReg() {
		return PHONE_REG;
	}

	public static String getPersonidReg() {
		return PERSONID_REG;
	}

	public static String getPasswordReg() {
		return Password_REG;
	}

	public static String getNameReg() {
		return NAME_REG;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberMail=" + memberMail + ", pwd=" + pwd + ", memberName="
				+ memberName + ", memberGender=" + memberGender + ", memberBirth=" + memberBirth + ", memberPhone="
				+ memberPhone + ", memberAddress=" + memberAddress + ", memberDiscountId=" + memberDiscountId
				+ ", memberCoin=" + memberCoin + ", member_status=" + member_status + ", register_date=" + register_date
				+ "]";
	}

}