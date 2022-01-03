package foodelicious.member.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotalDaoService {

	@Autowired
	private TotalDao totalDao;

	public void RegisterMember(Map<String, String> params) {
		totalDao.RegisterMember(params);
	}

	public boolean checkLogin(Account users) {
		return totalDao.checkLogin(users);
	}

	public Long findId(Account users) {
		return totalDao.findId(users);
	}
	
	public boolean checkLogin(String user, String pwd) {
		return totalDao.checkLogin(user, pwd);
	}
<<<<<<< HEAD
=======
	
//	public boolean checkPermission(Long id) {
//		return totalDao.checkPermission(id);
//	}
>>>>>>> c80e2fac799990216a55b860345ea3aa0683513e

	public String findId2(Long id) { return totalDao.findId2(id);}
	
}
