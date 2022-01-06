package foodelicious.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BkPageController {

    @GetMapping("/backend")
    public String main(){
        return "app.BackendMember";
    }

    @GetMapping("/backend/ProductAdd")
    public String backendProductAdd(){
        return "app.BackendProductAdd";
    }

    @GetMapping("/backend/member")
    public String backendMember(){
        return "app.BackendMember";
    }

    @GetMapping("/backend/memberUpdate")
    public String backendMemberUpdate(){
        return "app.BackendMemberUpdate";
    }

    @GetMapping("backend/manager")
    public String BackendManager(){ return "app.BackendManager";}


}
