package com.example.bookEstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookEstore.dao.AdminDao;
import com.example.bookEstore.model.Admin;



@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	
	
	@Override
public Boolean loginAdmin(String email, String pass) {
		
		List<Admin> admin = adminDao.loginAdmin(email, pass);
		
		for (Admin record : admin) {
	         if(  record.getEmail().equals(email) && record.getPass().equals(pass) ) {
	        	 System.out.println(record.getEmail());
	        	 System.out.println(record.getPass());
	        	 return true;
	        	 }
	        	 
	     } 
		
		return false;
	}

}
