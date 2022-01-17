package foodelicious.article.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import foodelicious.article.container.MessageRowMapper;
import foodelicious.article.model.ArticleData;
import foodelicious.article.model.MsgArea;
import foodelicious.article.repository.MsgRepository;
import foodelicious.member.model.Member;

@Repository
public class MsgRepositoryImpl implements MsgRepository {
	
	@PersistenceContext
	EntityManager em;
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public MsgRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		super();
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void insertMsg(Map<String, String> params) {
		//文章編號
		Integer articleId = Integer.parseInt(params.get("articleId"));		
		ArticleData articleData = em.find(ArticleData.class, articleId);
		//會員編號
		Long memberId = Long.parseLong(params.get("loginId"));		
		Member Member = em.find(Member.class, memberId);
		
		//做兩筆一對多的部分
		MsgArea msgArea = new MsgArea(params.get("text"));
		msgArea.setMemberName(Member.getMemberName());
		msgArea.setArticleData(articleData);
		msgArea.setMember(Member);
		em.persist(msgArea);
	}

	@Override
	public List<MsgArea> useIdFindAllMSG(Integer articleId) {
		String hql = "SELECT * FROM msgArea WHERE fk_article_id = :articleId";
		Map<String, Object> AllData = new HashMap<>();
		AllData.put("articleId", articleId);
		List<MsgArea> list = namedParameterJdbcTemplate.query(hql, AllData, new MessageRowMapper());
		return list;
	}

}
