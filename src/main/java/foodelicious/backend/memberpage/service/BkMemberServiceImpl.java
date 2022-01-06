package foodelicious.backend.memberPage.service;

import foodelicious.backend.memberPage.model.BkMember;
import foodelicious.backend.memberPage.model.BkMemberDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BkMemberServiceImpl implements BkMemberService {

    private final BkMemberDao bkMemberDao;

    public BkMemberServiceImpl(BkMemberDao bkMemberDao) {
        this.bkMemberDao = bkMemberDao;
    }

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
