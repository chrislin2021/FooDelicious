package foodelicious.backend.memberpage.dao;

import foodelicious.backend.memberpage.model.BkMember;

import java.util.List;


public interface BkMemberDao {

    public List<BkMember> getAllData();

    public List<BkMember> findByEmail(String searchEmail);

    public BkMember findById(Long memberId);

    public String update(Long memberId, BkMember bkMember);

    public String delete(Long memberId);
}
