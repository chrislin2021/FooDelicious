package foodelicious.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BkPageController {

    @GetMapping("/backend")
    public String main(){
        return "app.BackendMain";
    }

    @GetMapping("/backend/ProductAdd")
    public String backendProductAdd(){
        return "app.BackendProductAdd";
    }





}
