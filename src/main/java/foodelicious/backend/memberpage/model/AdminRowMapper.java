package foodelicious.backend.memberpage.model;




import foodelicious.member.model.Admin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRowMapper implements RowMapper<Admin> {

    @Override
    public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
        Admin admin = new Admin();

        admin.setPermission_level(rs.getString("permission_level"));


        return admin;
    }
}
