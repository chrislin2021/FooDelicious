package foodelicious.backend.memberpage.service.impl;


import java.util.List;

import foodelicious.backend.memberpage.service.BkMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodelicious.backend.memberpage.model.BkMember;
import foodelicious.backend.memberpage.dao.BkMemberDao;

@Service
public class BkMemberServiceImpl implements BkMemberService {

    @Autowired
    private BkMemberDao bkMemberDao;

    @Override
    public List<BkMember> getAllData() {
        return bkMemberDao.getAllData();
    }

    @Override
    public List<BkMember> findByEmail(String searchEmail){return bkMemberDao.findByEmail(searchEmail);};

    @Override
    public BkMember findById(Long memberId){
        return bkMemberDao.findById(memberId);
    }

    @Override
    public String update(Long memberId, BkMember bkMember){
        return bkMemberDao.update(memberId, bkMember);
    }

    @Override
    public String delete(Long memberId){
        return bkMemberDao.delete(memberId);};
}
