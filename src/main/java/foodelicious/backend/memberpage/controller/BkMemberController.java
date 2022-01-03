package foodelicious.backend.memberpage.controller;

import foodelicious.backend.memberpage.model.BkMember;
import foodelicious.backend.memberpage.service.BkMemberServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BkMemberController {

    private final BkMemberServiceInterface bkMemberServiceInterface;

    public BkMemberController(final BkMemberServiceInterface bkMemberServiceInterface) {
        this.bkMemberServiceInterface = bkMemberServiceInterface;
    }

    @GetMapping("/bkmembers")
    public List<BkMember> getAllData(){
        return bkMemberServiceInterface.getAllData();
    }

    @GetMapping("/bkmembers/{searchEmail}")
    public List<BkMember> getAllByAcc(@PathVariable String searchEmail){
        return bkMemberServiceInterface.findByEmail(searchEmail);
    }
}
