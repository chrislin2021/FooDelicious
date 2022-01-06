package foodelicious.backend.memberPage.service;

import foodelicious.backend.memberPage.model.BkMember;

import java.util.List;

public interface BkMemberService {

    public List<BkMember> getAllData();

    public List<BkMember> findByEmail(String searchEmail);

    public BkMember findById(Long memberId);

    public String update(Long memberId, BkMember bkMember);

    public String delete(Long memberId);
}
