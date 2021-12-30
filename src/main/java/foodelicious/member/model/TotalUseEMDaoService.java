package foodelicious.member.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotalUseEMDaoService {
	
	@Autowired
	TotalUseEMDao totalUseEMDao;
	
	public boolean checkLogin(Account users) {
		return totalUseEMDao.checkLogin(users);
	}
	public void RegisterMember(Map<String, String> params) {
		totalUseEMDao.RegisterMember(params);
	}
	public Long findId(Account users) {
		return totalUseEMDao.findId(users);
	}
	public String findId2(Long id) {
		return totalUseEMDao.findId2(id);
	}
}
