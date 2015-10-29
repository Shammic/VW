package com.misynss.dao.entitymapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.misynss.entity.User;

public final class UserMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();		
		user.setUsrid(rs.getString("usr_id"));
		user.setFirstname(rs.getString("first_name"));
		user.setUser_role_id(rs.getInt("usr_role_id"));
		user.setPassword(rs.getString("password"));
		user.setTitle(rs.getString("title"));
		user.setLastname(rs.getString("last_name"));
		user.setPw_ex_date(rs.getString("pw_expry_date"));
		user.setUsrstatus(rs.getString("usr_status").charAt(0));
		user.setEmail(rs.getString("email"));
		user.setMobile(rs.getString("mobile"));
		user.setCompany_id(rs.getInt("com_id"));
		user.setAtmpt_no(rs.getInt("attempt_no"));
		user.setPwchg_date(rs.getString("pw_chg_date"));
		user.setFirstlogin(rs.getString("first_login").charAt(0));
		user.setRec_status(rs.getString("rec_status").charAt(0));
		user.setInput_status(rs.getString("input_status").charAt(0));
		user.setInput_usr(rs.getString("input_usr"));
		user.setInput_time(rs.getString("input_time"));
		user.setAuth_stat1(rs.getString("auth_stat1").charAt(0));
		user.setAuth_usr1(rs.getString("auth_usr1"));
		user.setAuth_time1(rs.getString("auth_time1"));
		user.setAuth_stat2(rs.getString("auth_stat2").charAt(0));
		user.setAuth_usr2(rs.getString("auth_usr2"));
		user.setAuth_time2(rs.getString("auth_time2"));
		user.setCompany_name(rs.getString("com_name"));
		
		return user ;
	}

}
