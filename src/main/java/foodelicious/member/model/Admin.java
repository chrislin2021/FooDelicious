package foodelicious.member.model;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Entity(name="admin_data")
@Table (name="admin_data")
@Component
public class Admin implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private int admin_id;
	
	@Column(name = "permission_level")
	private String permission_level;

	@Column(name = "fk_admin_id")
	private Long fk_admin_id;


	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getPermission_level() {
		return permission_level;
	}

	public void setPermission_level(String permission_level) {
		this.permission_level = permission_level;
	}

	public Long getFk_admin_id() {
		return fk_admin_id;
	}

	public void setFk_admin_id(Long fk_admin_id) {
		this.fk_admin_id = fk_admin_id;
	}

	// foreign key 怎麼寫啦!!!
//	@OneToOne
//	@JoinColumn(name = "member_id", referencedColumnName = "member_id" )
//	private Account account;
}
