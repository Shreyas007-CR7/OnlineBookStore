package com.example.bookEstore.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public DataSource getDataSourceBean() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(); 
	
		dataSource.setUrl("jdbc:mysql://localhost:3306/springdb"); //change the database
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
		
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
