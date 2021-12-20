package foodelicious.mainpage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import foodelicious.member.model.Account;

@Controller
public class MainUpdateController {

	@Autowired
	private foodelicious.member.model.totalDaoServive totalDaoServive;
	
	@PostMapping("/register.controller")
	public String registerController(@RequestBody Map<String, String> params) {
//		System.out.println(params);
//		System.out.println(params.get("account"));
		totalDaoServive.RegisterMember(params);
		return "app.home";
	}
	
	@PostMapping(path = "/checklogin.controller")
	public String processAction(@RequestParam("userAccount")String account, 
								@RequestParam("userPwd")String pwd, 
								Model m, 
								HttpSession session) {		
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		if(account==null || account.length()==0) {
			errors.put("account", "請輸入帳號");
		}
		if(pwd==null || pwd.length()==0) {
			errors.put("pwd", "請輸入密碼");
		}
		if(errors!=null && !errors.isEmpty()) {
			return "app.LoginSystem";
		}
		
		boolean resultStatus = totalDaoServive.checkLogin(new Account(account, pwd));
		if(resultStatus) {
			m.addAttribute("account", account);
			m.addAttribute("pwd", pwd);
			int id = totalDaoServive.findId(new Account(account, pwd));
			session.setAttribute("account", account);
			session.setAttribute("pwd", pwd);
			session.setAttribute("userID", id);
			
			System.out.println("userID："+session.getAttribute("userID"));
			return "app.home";
		}
		
		errors.put("msg", "Pleas Input Correct Username or Password");
		return "app.LoginSystem";	
	}

}
