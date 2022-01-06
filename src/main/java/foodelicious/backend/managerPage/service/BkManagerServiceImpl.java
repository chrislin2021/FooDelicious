package foodelicious.backend.managerPage.service;

import foodelicious.backend.managerPage.model.BkManagerDao;
import foodelicious.backend.memberPage.model.BkMember;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BkManagerServiceImpl implements BkManagerService{

    private BkManagerDao bkManagerDao;

    public BkManagerServiceImpl(BkManagerDao bkManagerDao) {
        this.bkManagerDao = bkManagerDao;
    }

    @Override
    public List<BkMember> findAllManager() {
        return bkManagerDao.findAllManager();
    }

    @Override
    public List<BkMember> findByMail(String mail) {
        return bkManagerDao.findByMail(mail);
    }

    @Override
    public BkMember findById(Long memberId) {
        return bkManagerDao.findById(memberId);
    }

    @Override
    public String update(Long memberId, BkMember bkMember) {
        return bkManagerDao.update(memberId,bkMember);
    }
}
