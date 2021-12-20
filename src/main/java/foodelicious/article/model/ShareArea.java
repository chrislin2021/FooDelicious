package foodelicious.article.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import foodelicious.member.model.Account;

@Entity
@Table(name = "share_area")
@Component
public class ShareArea implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "share_id")
	private int share_id;

	@NotBlank(message = "標題不能空白喔")
	@Size(min = 3, max = 255, message = "最少要輸入3個字喔")
	@Column(name = "article_title")
	private String article_title;

	@Column(name = "article_clallify")
	private String article_clallify;// 文章分類

	@Column(name = "viewNum")
	private int viewNum;

	@Column(name = "article_likes")
	private int article_likes;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "postTime")
	private Date postTime;

	@Column(name = "fk_account_id")
	@Transient
	private int fk_account_id;

	@OneToOne(mappedBy = "shareArea")
	private ArticleData articleData;
	
	// 多對一 這邊沒有casecade連動 所以要注意
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_account_id")
	private Account account;

	public ShareArea() {
	}

	
}
