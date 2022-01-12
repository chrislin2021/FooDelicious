package foodelicious.CustomerService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@PostMapping("/add")
	public boolean addProblem(CustomerService requestObject) { //名為addProblem的function，傳入一個CustomerService的物件叫requestObject, 回傳boolean
		return customerServiceServiceImpl.addProblem(requestObject); //回傳service層addProblem function處理的結果
		
	}


//        CustomerServiceRepository.save(problem);
//        return "redirect:/CustomerService";
//    }
//    
//    @GetMapping("/index")
//    public String showUserList(Model model) {
//        model.addAttribute("users", CustomerServiceRepository.findAll());
//        return "index";
//    }
//    
//    @PostMapping("/update/{id}")
//    public String updateUser(@PathVariable("id") long id, @Valid User user, 
//      BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            user.setId(id);
//            return "update-user";
//        }
//            
//        userRepository.save(user);
//        return "redirect:/index";
//    }
	
//    @PostMapping("/test")
//    public String checkUser(@Valid User user, BindingResult bindingResult, RedirectAttributes attr) {
//    	if (bindingResult.hasErrors()) {
//    		return "CustomerService";
//    	}
//    	
//    	//用redirect來防止重複提交
//    	attr.addFlashAttribute("user", user);
//    	return "redirect:/results";
//    }
}