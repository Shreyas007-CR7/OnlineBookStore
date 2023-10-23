package com.example.bookEstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.example.bookEstore.model.Admin;

public class AdminMapper implements RowMapper<Admin> {

	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		com.example.bookEstore.model.Admin admin = new Admin();
		
		admin.setEmail(rs.getString("email"));
		admin.setPass(rs.getString("pass"));
		
		return admin;
	}
}
