package foodelicious.member.model;

import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class totalDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	// 管理登入
	public boolean checkLogin(Account users) {
		Session session = sessionFactory.openSession();
		String hqlstr = "FROM account_data WHERE account =:user AND pwd = :pwd";
		Query<Account> query = session.createQuery(hqlstr, Account.class);
		query.setParameter("user", users.getAccountMake());
		query.setParameter("pwd", users.getPwd());

		Account account = query.uniqueResult();

		session.close();

		if (account != null) {
			return true;
		}
		return false;
	}
	
	public void RegisterMember(Map<String, String> params) {
		Session session = sessionFactory.openSession();
		System.out.println(params);
		Member mem = new Member();
		mem.setUserName(params.get("member_name"));
		mem.setMember_birth(params.get("member_birth"));
		mem.setMember_phone(params.get("member_phone"));
		mem.setMember_address(params.get("member_address"));
		mem.setUserEmail(params.get("member_mail"));
		
		Account acc = new Account();
		acc.setAccountMake(params.get("account"));
		acc.setPwd(params.get("pwd"));	
		
		mem.setAccount(acc);
		
		session.save(mem);
		session.close();
	}
	
	public int findId(Account users) {
		Session session = sessionFactory.openSession();
		
		String hqlstr = "FROM account_data WHERE account =:user AND pwd = :pwd";
		Query<Account> query = session.createQuery(hqlstr, Account.class);
		query.setParameter("user", users.getAccountMake());
		query.setParameter("pwd", users.getPwd());
		
		Account account = query.uniqueResult();
		session.close();
		return account.getAccount_id();		
	}
}
