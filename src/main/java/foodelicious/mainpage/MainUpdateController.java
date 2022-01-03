package foodelicious.mainpage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import foodelicious.member.model.Admin;
import foodelicious.member.model.TotalDaoService;
import foodelicious.member.model.TotalUseEMDaoService;

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
	
	//測試
	@Autowired
	TotalUseEMDaoService EMDaoService;

	@PostMapping("/register.controller")
	public String registerController(@RequestBody Map<String, String> params) {
//		System.out.println(params);
//		System.out.println(params.get("account"));
		EMDaoService.RegisterMember(params);
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

		boolean resultStatus = EMDaoService.checkLogin(new Account(account, pwd));
		if (resultStatus) {
			m.addAttribute("account", account);
			m.addAttribute("pwd", pwd);
//			Long id = totalDaoService.findId(new Account(account, pwd));
			Long EMid = EMDaoService.findId(new Account(account, pwd));
			session.setAttribute("account", account);
			session.setAttribute("pwd", pwd);
			session.setAttribute("userID", EMid);
			
			
			System.out.println("EMid："+EMid);

			//查詢成功登入的會員身份
			String level = EMDaoService.findId2(EMid);
			System.out.println("level：" + level);
			if(level.equals("admin")){
				return "app.BackendMember";
			}else if(level.equals("company")){
				return "app.CompanyMain";
			}else{
				System.out.println("userID：" + session.getAttribute("userID"));
				return "app.home";
			}

		}

		errors.put("msg", "Pleas Input Correct Username or Password");
		return "app.LoginSystem";
	}
	
	
}
