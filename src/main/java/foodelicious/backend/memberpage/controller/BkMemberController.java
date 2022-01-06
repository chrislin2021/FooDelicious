package foodelicious.backend.memberPage.controller;

import foodelicious.backend.memberPage.model.BkMember;
import foodelicious.backend.memberPage.repository.BkCrudRepository;
import foodelicious.backend.memberPage.service.BkMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BkMemberController {

    private BkMemberService bkMemberService;

    @Autowired
    private BkCrudRepository bkCrudRepository;

    public BkMemberController(BkMemberService bkMemberService) {
        this.bkMemberService = bkMemberService;
    }

    @GetMapping("/bkmembers")
    public List<BkMember> getAllData(){
        return bkMemberService.getAllData();
    }

    @GetMapping("/bkmembers/{searchEmail}")
    public List<BkMember> getAllByAcc(@PathVariable String searchEmail){
        return bkMemberService.findByEmail(searchEmail);
    }

    @GetMapping("/bkmembers/update/{memberId}")
    public BkMember findById(@PathVariable Long memberId){
        return bkMemberService.findById(memberId);
    }

    @PutMapping("/bkmembers/update/{memberId}")
    public String update(@PathVariable Long memberId,
                         @RequestBody BkMember bkMember){
        return bkMemberService.update(memberId, bkMember);
    }

    @DeleteMapping("/bkmembers/delete/{memberId}")
    public String delete(@PathVariable Long memberId){
        return bkMemberService.delete(memberId);
    }

}
