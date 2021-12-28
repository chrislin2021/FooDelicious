package foodelicious.mainpage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import foodelicious.member.model.TotalDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import foodelicious.member.model.Account;

@Controller
public class MainUpdateController {

	@Autowired
	private TotalDaoService totalDaoService;

	@PostMapping("/register.controller")
	public String registerController(@RequestBody Map<String, String> params) {
//		System.out.println(params);
//		System.out.println(params.get("account"));
		totalDaoService.RegisterMember(params);
		return "app.home";
	}

	@PostMapping(path = "/checklogin.controller")
	public String processAction(@RequestParam("userAccount") String account, @RequestParam("userPwd") String pwd,
			Model m, HttpSession session) {
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);

		if (account == null || account.length() == 0) {
			errors.put("account", "請輸入帳號");
		}
		if (pwd == null || pwd.length() == 0) {
			errors.put("pwd", "請輸入密碼");
		}
		if (errors != null && !errors.isEmpty()) {
			return "app.LoginSystem";
		}

		boolean resultStatus = totalDaoService.checkLogin(new Account(account, pwd));
		if (resultStatus) {
			m.addAttribute("account", account);
			m.addAttribute("pwd", pwd);
			Long id = totalDaoService.findId(new Account(account, pwd));
			session.setAttribute("account", account);
			session.setAttribute("pwd", pwd);
			session.setAttribute("userID", id);

			System.out.println("userID：" + session.getAttribute("userID"));
			return "app.home";
		}

		errors.put("msg", "Pleas Input Correct Username or Password");
		return "app.LoginSystem";
	}
	
<<<<<<< HEAD
	//檢查 1.帳號有沒有存在 2.是會員還是廠商 3. 導向不同的頁面
	@RequestMapping("/checklogin2.controller")
	public String checkLogin(@RequestParam(name="userAccount") String username, @RequestParam(name="userPwd") String pwd, Model model, HttpSession session) {
		
		Map <String,String> errors = new HashMap<>();
		
		model.addAttribute("errors", errors);

		if (username == null || username.length() == 0) {
			errors.put("account", "請輸入帳號");
		}
		if (pwd == null || pwd.length() == 0) {
			errors.put("pwd", "請輸入密碼");
		}
		if (errors != null && !errors.isEmpty()) {
			return "app.LoginSystem";
		}
		
		boolean exist = totalDaoService.checkLogin(username,pwd);
		if (exist) {
			model.addAttribute("account", username);
			model.addAttribute("pwd", pwd);
			Long id = totalDaoService.findId(new Account(username, pwd));
			session.setAttribute("account", username);
			session.setAttribute("pwd", pwd);
			session.setAttribute("userID", id);
			
			boolean permission = totalDaoService.checkPermission(id);
			
			return null;

			
		}
		else {
			errors.put("incorrect", "帳號或密碼不正確,請重新輸入");
			return "app.LoginSystem";
		}
	}
=======

>>>>>>> 1fb1fc695ba2cfe9f78c7075f34d3c9fd8c80301
}
