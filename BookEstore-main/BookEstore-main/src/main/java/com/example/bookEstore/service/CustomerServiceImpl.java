package com.example.bookEstore.service;

import com.example.bookEstore.dao.CustomerDao;
import com.example.bookEstore.model.Book;
import com.example.bookEstore.model.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void setCustomerDao(CustomerDao customerDao,PasswordEncoder passwordEncoder) {
		this.customerDao = customerDao;
		this.passwordEncoder=passwordEncoder;
	}
	
	
	@Override
	public int addCustomer(Customer customer) {
		
		
		int noOfRow = customerDao.addCustomer(customer);
		

		return noOfRow;
	}

	@Override
	public Boolean loginCustomer(String email, String pass) {
		
		List<Customer> customers = customerDao.loginCustomer(email, pass);
		
		for (Customer record : customers) {
			if (passwordEncoder.matches(pass, record.getPassword())) {
				// Passwords match, login successful
				return true;
			}
	        	 
	     } 
		
		return false;
	}


	@Override
	public List<Customer> showAllUsers() {
		List<Customer> customer =customerDao.showAllCustomers();
		return customer;
	}

}
