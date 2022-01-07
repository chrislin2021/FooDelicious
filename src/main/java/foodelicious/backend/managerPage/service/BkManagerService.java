package foodelicious.backend.managerPage.service;

import foodelicious.backend.memberpage.model.BkMember;

import java.util.List;

public interface BkManagerService {

    public List<BkMember> findAllManager();

    public List<BkMember> findByMail(String mail);

    public BkMember findById(Long memberId);

    public String update(Long memberId,BkMember bkMember);
}
