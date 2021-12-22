package foodelicious.member.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class totalDaoService {
	
	@Autowired
	private totalDao totalDao;
	
	public void RegisterMember(Map<String, String> params) {
		totalDao.RegisterMember(params);
	}
	
	public boolean checkLogin(Account users) {
		return totalDao.checkLogin(users);
	}
	
	public int findId(Account users) {
		return totalDao.findId(users);
	}
}
