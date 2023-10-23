package com.example.bookEstore.dao;

import com.example.bookEstore.model.Admin;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
@Repository
public class AdminDaoImpl implements AdminDao {

	private final static String SQL_SRCH_Admin = "select * from Admin";
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Admin> loginAdmin(String email, String pass) {
		List <Admin> admin = jdbcTemplate.query(SQL_SRCH_Admin, new AdminMapper());
	      return admin;
	}
	
	

}
