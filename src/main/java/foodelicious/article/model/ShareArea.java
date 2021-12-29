package foodelicious.article.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

//import foodelicious.member.model.Account;

@Entity
@Table(name = "share_area")
public class ShareArea implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "share_id")
	private int share_id;

	@NotBlank(message = "標題不能空白喔")
	@Size(min = 3, max = 255, message = "最少要輸入3個字喔")
	@Column(name = "article_title")
	private String article_title;
	
	// 文章分類
	@Column(name = "article_clallify")
	private String article_clallify;
	
	//觀看數
	@Column(name = "viewNum")
	private int viewNum;

	//喜歡or收藏文章數
	@Column(name = "article_likes")
	private int article_likes;

	//自動生成 別寫
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "postTime")
	private Date postTime;

	@PrePersist // 設定物件轉換為 Persistent 以前執行
	private void onCreate() {
		if(postTime == null) {
			postTime = new Date();
		}
	}
	
	@Column(name = "fk_account_id")	
	private Long fk_account_id;

	@OneToOne(mappedBy = "shareArea")
	private ArticleData articleData;

	// 多對一 這邊沒有casecade連動 所以要注意
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "fk_account_id")
//	private Account account;

	public ShareArea() {
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getArticle_clallify() {
		return article_clallify;
	}

	public void setArticle_clallify(String article_clallify) {
		this.article_clallify = article_clallify;
	}

	public int getViewNum() {
		return viewNum;
	}

	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}

	public int getArticle_likes() {
		return article_likes;
	}

	public void setArticle_likes(int article_likes) {
		this.article_likes = article_likes;
	}

	public Long getFk_account_id() {
		return fk_account_id;
	}

	public void setFk_account_id(Long fk_account_id) {
		this.fk_account_id = fk_account_id;
	}

	public ArticleData getArticleData() {
		return articleData;
	}

	public void setArticleData(ArticleData articleData) {
		this.articleData = articleData;
	}

//	public Account getAccount() {
//		return account;
//	}
//
//	public void setAccount(Account account) {
//		this.account = account;
//	}

	public int getShare_id() {
		return share_id;
	}
	
	
}
