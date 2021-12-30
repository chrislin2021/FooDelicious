package foodelicious.backend.memberpage.service;

import foodelicious.backend.memberpage.model.BkMember;
import foodelicious.backend.memberpage.model.BkMemberDaoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BkMemberService implements BkMemberServiceInterface {

    @Autowired
    private BkMemberDaoInterface bkMemberDaoInterface;

    @Override
    public List<BkMember> getAllData() {
        return bkMemberDaoInterface.getAllData();
    }
}