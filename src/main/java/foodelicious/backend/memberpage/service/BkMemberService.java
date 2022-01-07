package foodelicious.backend.memberpage.service;
<<<<<<< HEAD
=======

import foodelicious.backend.memberpage.model.BkMember;
>>>>>>> origin/master

import java.util.List;

import foodelicious.backend.memberpage.model.BkMember;



public interface BkMemberService {

    public List<BkMember> getAllData();

    public List<BkMember> findByEmail(String searchEmail);

    public BkMember findById(Long memberId);

    public String update(Long memberId, BkMember bkMember);

    public String delete(Long memberId);
}
