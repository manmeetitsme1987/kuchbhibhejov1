package com.kuchbhibhejo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kuchbhibhejo.controller.KuchBhiBhejoAdmin;

public class KuchBhiBhejoAdminMapper implements RowMapper<KuchBhiBhejoAdmin> {
	   public KuchBhiBhejoAdmin mapRow(ResultSet rs, int rowNum) throws SQLException {
		   	  KuchBhiBhejoAdmin admin = new KuchBhiBhejoAdmin();
		   	  admin.setEmail(rs.getString("email"));
		      admin.setId(rs.getInt("Admin_Id"));
		      admin.setName(rs.getString("Name"));
		      admin.setPassword(rs.getString("Password"));
		      admin.setSecret(rs.getString("Secret"));
		      admin.setUserName(rs.getString("UserName"));
		      return admin;
		   }
}
