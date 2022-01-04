package foodelicious.backend.memberpage.model;

import foodelicious.backend.memberpage.repository.BkCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BkMemberDao implements BkMemberDaoInterface {

    @Autowired
    private BkCrudRepository bkcrud;



    @Override
    public List<BkMember> getAllData() {
        List<BkMember> members = (List<BkMember>) bkcrud.findAll();
        return members;
    }

    @Override
    public List<BkMember> findByEmail(String searchEmail){

        List<BkMember> accounts = bkcrud.findByEmail(searchEmail);

        return accounts;
    }
}
