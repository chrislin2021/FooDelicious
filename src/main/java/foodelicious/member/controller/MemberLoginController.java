package foodelicious.member.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.support.SessionStatus;


@Controller
public class MemberLoginController {

	@GetMapping("/normallogout")
	public String logout(HttpServletRequest request, HttpServletResponse response, SessionStatus status) {
		HttpSession session = request.getSession();
		status.setComplete();
		session.invalidate(); // session.invalidate()讓SESSION失效.

		return "redirect:/";
	}
}
