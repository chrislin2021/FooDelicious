package foodelicious.member.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import foodelicious.member.model.Admin;
import foodelicious.backend.memberpage.model.AdminRowMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TotalDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// 管理登入
	//=========引用到舊的Account先註解===========
//	public boolean checkLogin(Account users) {
//		Session session = sessionFactory.openSession();
//		String hqlstr = "FROM account_data WHERE account =:user AND pwd = :pwd";
//		Query<Account> query = session.createQuery(hqlstr, Account.class);
//		query.setParameter("user", users.getAccountMake());
//		query.setParameter("pwd", users.getPwd());
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

//	public void RegisterMember(Map<String, String> params) {
//		Session session = sessionFactory.openSession();
////		System.out.println(params);
//		Member mem = new Member();
//		mem.setUserName(params.get("member_name"));
//		mem.setMember_birth(params.get("member_birth"));
//		mem.setMember_phone(params.get("member_phone"));
//		mem.setMember_address(params.get("member_address"));
//		mem.setUserEmail(params.get("member_mail"));
//
//		Account acc = new Account();
//		acc.setAccountMake(params.get("account"));
//		acc.setPwd(params.get("pwd"));
//
//		mem.setAccount(acc);
//
//		session.save(mem);
//		session.close();
//	}

	//=========引用到舊的Account先註解===========
//	public Long findId(Account users) {
//		Session session = sessionFactory.openSession();
//
//		String hqlstr = "FROM account_data WHERE account =:user AND pwd = :pwd";
//		Query<Account> query = session.createQuery(hqlstr, Account.class);
//		query.setParameter("user", users.getAccountMake());
//		query.setParameter("pwd", users.getPwd());
//
//		Account account = query.uniqueResult();
//		session.close();
//		return (Long) account.getAccount_id();
//	}
//
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


	public String findId2(Long id) {
		String sql = "SELECT permission_level FROM admin_data WHERE fk_admin_id =:accountId";
		Map<String, Object> map = new HashMap<>();
		map.put("accountId", id);

		List<Admin> list = namedParameterJdbcTemplate.query(sql, map, new AdminRowMapper());
		if(list.size() > 0){
			String adminLevel = list.get(0).getPermission_level();
			return adminLevel;
		}else{
			return "null";
		}

	}
	
}
