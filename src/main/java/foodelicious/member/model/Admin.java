package foodelicious.member.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table (name= "admin_data")
@Component
public class Admin {
	
	@Id
	@Column(name = "member_id")
	private int member_id;
	
	@Column(name = "permission_level")
	private String permission_level;
	
	
	// foreign key 怎麼寫啦!!!
//	@OneToOne
//	@JoinColumn(name = "member_id", referencedColumnName = "member_id" )
//	private Account account;
}
