package com.misynss.dao.entitymapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.misynss.entity.Privilage;
import com.misynss.entity.User;

public final class PrivilageMapper implements RowMapper<Privilage>{

	public Privilage mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Privilage privilage = new Privilage();		
		privilage.setId(rs.getInt("privilage_id"));
		privilage.setName(rs.getString("privilage_name"));	
		return privilage ;
	}

}
