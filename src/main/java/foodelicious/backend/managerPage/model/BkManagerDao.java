package foodelicious.backend.managerPage.model;

import foodelicious.backend.memberpage.model.BkMember;

import java.util.List;

public interface BkManagerDao {

    public List<BkMember> findAllManager();

    public List<BkMember> findByMail(String mail);

    public BkMember findById(Long memberId);

    public String update(Long memberId,BkMember bkMember);

}
