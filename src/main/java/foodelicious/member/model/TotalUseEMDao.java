package foodelicious.member.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import foodelicious.backend.memberpage.model.AdminRowMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TotalUseEMDao {

	@PersistenceContext
	EntityManager em;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	// 管理登入
	public boolean checkLogin(Member users) {
		TypedQuery<Member> member = null;
		String hqlstr = "FROM member_data2 WHERE member_mail =:user AND pwd = :pwd";
		member = em.createQuery(hqlstr, Member.class)
				    .setParameter("user", users.getMemberMail())
					.setParameter("pwd", users.getPwd());
		
		List<Member> accountData = member.getResultList();
		if (accountData != null) {
			em.close();
			return true;
		}
		em.close();
		return false;
	}

//	public void RegisterMember(Map<String, String> params) {
//		Member mem = new Member();
//		mem.setMemberName(params.get("member_name"));
//		mem.setMemberBirth(params.get("member_birth"));
//		mem.setMemberPhone(params.get("member_phone"));
//		mem.setMemberAddress(params.get("member_address"));
//		mem.setUserEmail(params.get("member_mail"));
//
//		Account acc = new Account();
//		acc.setAccountMake(params.get("account"));
//		acc.setPwd(params.get("pwd"));
//
//		mem.setAccount(acc);
//		//em.persist是新增用的(Insert)
//		em.persist(mem);
//		em.close();
//	}

	public Long findId(Member users) {
		TypedQuery<Member> query = null;
		String hqlstr = "FROM member_data2 WHERE member_mail =:user AND pwd = :pwd";
		query = em.createQuery(hqlstr, Member.class);
		query.setParameter("user", users.getMemberMail());
		query.setParameter("pwd", users.getPwd());

		Member account =  query.getSingleResult();
		em.close();
		return account.getMemberId();
	}

//	// overload checkLogin
//	public boolean checkLogin(String user, String pwd) {
//		Session session = sessionFactory.openSession();
//		String hqlstr = "FROM account_data WHERE account =:user AND pwd = :pwd";
//		Query<Account> query = session.createQuery(hqlstr, Account.class);
//		query.setParameter("user", user);
//		query.setParameter("pwd", pwd);
//
//		Account account = query.uniqueResult();
//
//		session.close();
//
//		if (account != null) {
//			return true;
//		}
//		return false;
//	}
//
//	//hql 的 join 好像不是這樣寫的....
//	public boolean checkPermission(Long id) {
//		Session session = sessionFactory.openSession();
//		String hqlstr = "FROM admin_data LEFT JOIN account_data.account_id WHERE account_id = :id";
//		Query<Admin> query = session.createQuery(hqlstr);
//		query.setParameter("id", id);
//		List result = query.list();
//		
//		session.close();
//	
//		return false;
//	
// }
	public String findId2(Long id) {
		String sql = "SELECT permission_level FROM admin_data WHERE fk_admin_id =:accountId";
		Map<String, Object> map = new HashMap<>();
		map.put("accountId", id);

		List<foodelicious.member.model.Admin> list = namedParameterJdbcTemplate.query(sql, map, new AdminRowMapper());
		if(list.size() > 0){
			String adminLevel = list.get(0).getPermission_level();
			return adminLevel;
		}else{
			return "null";		}

	}
	
}