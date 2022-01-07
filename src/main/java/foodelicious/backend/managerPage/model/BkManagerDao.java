package foodelicious.backend.managerPage.model;

<<<<<<< HEAD
=======
import foodelicious.backend.memberpage.model.BkMember;

>>>>>>> origin/master
import java.util.List;

import foodelicious.backend.memberpage.model.BkMember;

public interface BkManagerDao {

    public List<BkMember> findAllManager();

    public List<BkMember> findByMail(String mail);

    public BkMember findById(Long memberId);

    public String update(Long memberId,BkMember bkMember);

}
