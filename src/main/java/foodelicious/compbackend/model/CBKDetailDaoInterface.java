package foodelicious.compbackend.model;

import foodelicious.member.model.Member;

public interface CBKDetailDaoInterface {
	
	public Member findByCompanyId(Long companyId);

}
