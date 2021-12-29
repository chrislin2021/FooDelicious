package foodelicious.backend.memberpage.model;

import foodelicious.member.model.Account;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "member_data")
public class BkMember implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_gender")
    private String memberGrander;

    @Column(name = "member_birth")
    private String memberBirth;

    @Column(name = "member_phone")
    private String memberPhone;

    @Column(name = "member_address")
    private String memberAddress;

    @Column(name = "member_coin")
    private Integer memberCoin;

    @Column(name = "member_mail")
    private String memberMail;

    @Column(name = "member_discount_id")
    private Integer discount;

    @Column(name = "member_img")
    private String memberPic;

    @Column(name = "fk_account_id")
    @Transient
    private Integer fkAccountId;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_account_id", referencedColumnName = "account_id")
//    private BkAccount bkAccount;

    public Integer getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberGrander() {
        return memberGrander;
    }

    public void setMemberGrander(String memberGrander) {
        this.memberGrander = memberGrander;
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

    public Integer getMemberCoin() {
        return memberCoin;
    }

    public void setMemberCoin(Integer memberCoin) {
        this.memberCoin = memberCoin;
    }

    public String getMemberMail() {
        return memberMail;
    }

    public void setMemberMail(String memberMail) {
        this.memberMail = memberMail;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getMemberPic() {
        return memberPic;
    }

    public void setMemberPic(String memberPic) {
        this.memberPic = memberPic;
    }

    public Integer getFkAccountId() {
        return fkAccountId;
    }

    public void setFkAccountId(Integer fkAccountId) {
        this.fkAccountId = fkAccountId;
    }

//    public BkAccount getBkAccount() {
//        return bkAccount;
//    }
//
//    public void setBkAccount(BkAccount bkAccount) {
//        this.bkAccount = bkAccount;
//    }
}
