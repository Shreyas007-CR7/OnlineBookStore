package com.example.bookEstore.dao;

import java.util.List;

import com.example.bookEstore.model.Admin;

public interface AdminDao {

	public List<Admin> loginAdmin(String email, String pass);

}
