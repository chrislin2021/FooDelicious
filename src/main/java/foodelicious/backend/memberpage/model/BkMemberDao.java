package foodelicious.backend.memberpage.model;

import foodelicious.backend.memberpage.repository.BkCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BkMemberDao implements BkMemberDaoInterface {

    private final BkCrudRepository bkcrud;

    public BkMemberDao(BkCrudRepository bkcrud) {
        this.bkcrud = bkcrud;
    }

    @Override
    public List<BkMember> getAllData() {
        List<BkMember> members = (List<BkMember>) bkcrud.findAll();
        return members;
    }
}
