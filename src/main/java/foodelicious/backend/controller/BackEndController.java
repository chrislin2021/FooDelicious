package foodelicious.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BackEndController {

    @GetMapping(path = "/backend")
    public String main(){
        return "app.BackendMain";
    }

}
