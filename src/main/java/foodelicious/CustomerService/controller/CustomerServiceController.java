package foodelicious.CustomerService.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/MessageBoard") // 導至客戶問答紀錄頁面
	public String getMessageBoard() {
		return "app.MessageBoard";
	}
	
	@GetMapping("/ReplyPage") // 導至客服回覆頁面
	public String getReplyPage() {
		return "app.ReplyPage";
	}
	
	@ResponseBody //告知controller回傳的物件自動序列化成JSON
	@PostMapping("/add") //新增留言
	public boolean addProblem(@RequestBody Map<String, String> params) { //名為addProblem的function，傳入一個CustomerService的物件叫requestObject, 回傳boolean
		System.out.println("test ok");
		System.out.println(params.get("Id"));
		System.out.println(params.get("cstm_Id"));

		var requestObject = new CustomerService();
		requestObject.setCstm_name(params.get("cstm_name"));
		requestObject.setCstm_email(params.get("cstm_email"));
		requestObject.setProblem_Type(params.get("problem_Type"));
		requestObject.setProblem_Text(params.get("problem_Text"));
		requestObject.setProblem_postTime(LocalDateTime.now());
		return customerServiceServiceImpl.addProblem(requestObject); //回傳service層addProblem function處理的結果
	}
	
	@GetMapping("/query/{email}") //查詢留言
	public String queryProblem(@PathVariable(value = "email", required = false) String email, Model model) { 
		var cslist = customerServiceServiceImpl.queryProblem(email);
		model.addAttribute("abc", cslist);
//		System.out.println(cslist);
//		System.out.println("hello");
		return "app.MessageBoard";
	}
	
	@ResponseBody
	@PostMapping("/delete") //由Id辨識並刪除留言
	public boolean deleteProblem(@RequestBody Map<String, String> params) { 
		return customerServiceServiceImpl.deleteProblem(Long.parseLong(params.get("Id")));
	}
	
	@ResponseBody
	@PostMapping("/update") //編輯留言
	public boolean updateProblem(@RequestBody Map<String, String> params) { 
		var updateObject = new CustomerService();
		updateObject.setId(Long.parseLong(params.get("Id")));
		updateObject.setCstm_name(params.get("cstm_name"));
		updateObject.setCstm_email(params.get("cstm_email"));
		updateObject.setProblem_Type(params.get("problem_Type"));
		updateObject.setProblem_Text(params.get("problem_Text"));
		updateObject.setProblem_postTime(LocalDateTime.now());
		return customerServiceServiceImpl.updateProblem(updateObject);
	}
	
	//按送出後同步發送email到客服信箱
//	@GetMapping("/mailto")
//	@ResponseBody
	public String hithere() {
		//mailService.prepareAndSend("user's email", "email subject");
		return "Mail Sent Successfully";
	}
    	
}