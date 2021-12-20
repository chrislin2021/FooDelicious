package foodelicious.article.model;

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
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "article_data")
@Component
public class ArticleData implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="article_id")
	private int article_id;
	
	@Size(min = 15, max = 255, message = "內容不得小於15個字唷")
	@Column(name="article")
	private String article;
	
	@Column(name="block_Img")
	private String block_Img;
	
	@Column(name="tag_name")
	private String tag_name;
	
	@Column(name="releaseOrder")
	private int releaseOrder;//該討論串的發布順序 編號1為第一篇文章
	
	@Transient
	@Column(name="fk_share_id")
	private int fk_share_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_share_id", referencedColumnName = "share_id")
	private ShareArea shareArea;
	
	public ArticleData() {	
	}

}
