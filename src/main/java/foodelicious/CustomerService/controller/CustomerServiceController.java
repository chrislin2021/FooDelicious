package foodelicious.CustomerService.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import foodelicious.CustomerService.model.CustomerService;
import foodelicious.CustomerService.model.CustomerServiceDaoInterface;
import foodelicious.CustomerService.service.CustomerService_Service;
import foodelicious.CustomerService.service.CustomerService_ServiceImpl;

@Controller
@RequestMapping("/customerService")
public class CustomerServiceController {

	@Autowired
	private CustomerService_ServiceImpl customerServiceServiceImpl;

	@Autowired
	public CustomerServiceController(CustomerService_ServiceImpl customerServiceServiceImpl) {
		super();
		this.customerServiceServiceImpl = customerServiceServiceImpl;
	}

	@GetMapping // 導至客服中心頁面
	public String getCustomerService() {
		return "app.CustomerService";
	}
	
	@GetMapping("/MessageBoard") // 導至客服中心頁面
	public String getMessageBoard() {
		return "app.MessageBoard";
	}
	
	@ResponseBody
	@PostMapping("/add") //新增留言
	public boolean addProblem(CustomerService requestObject) { //名為addProblem的function，傳入一個CustomerService的物件叫requestObject, 回傳boolean
		System.out.println("test ok");
		System.out.println(requestObject.getProblem_Text());
		return true;
		//return customerServiceServiceImpl.addProblem(requestObject); //回傳service層addProblem function處理的結果	
	}
	
	@ResponseBody //告知controller回傳的物件自動序列化成JSON
	@PostMapping("/add2") //新增留言
	public boolean addProblem2(@RequestBody Map<String, String> params) { //名為addProblem的function，傳入一個CustomerService的物件叫requestObject, 回傳boolean
		System.out.println("test ok");
		System.out.println(params.get("Id"));
		System.out.println(params.get("cstm_Id"));

		var requestObject = new CustomerService();
		requestObject.setCstm_name(params.get("cstm_name"));
		requestObject.setCstm_email(params.get("cstm_email"));
		requestObject.setProblem_Type(params.get("problem_Type"));
		requestObject.setProblem_Text(params.get("problem_Text"));
		requestObject.setProblem_postTime(LocalDateTime.now());
		//return true;
		return customerServiceServiceImpl.addProblem(requestObject); //回傳service層addProblem function處理的結果
	}
	
	@ResponseBody
	@PostMapping("/test")
	public Map<String, Object> test() {
		System.out.println("hello");
		Map<String, Object> data = new HashMap<>();
		data.put("LoginId", "test2");
		System.out.println("endhello2");
		
		return data;
	}

	
	@ResponseBody
	@GetMapping("/test2")
	public Map<String, Object> test2() {
		System.out.println("hello2");
		Map<String, Object> data = new HashMap<>();
		data.put("LoginId", "test2");
		System.out.println("endhello2");
		
		return data;
	}
	
	@ResponseBody
	@GetMapping("/test3")
	public String test3() {
		System.out.println("hello2");
		Map<String, Object> data = new HashMap<>();
		data.put("LoginId", "test2");
		System.out.println("endhello2");
		
		return "OK";
	}
	
	//按送出後同步發送email到客服信箱
	@GetMapping("/mailto")
	@ResponseBody
	public String hithere() {
		//mailService.prepareAndSend("user's email", "email subject");
		return "Mail Sent Successfully";
	}
//    	
//    	//用redirect來防止重複提交
//    	attr.addFlashAttribute("user", user);
//    	return "redirect:/results";
//    }
}