package com.example.bookEstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.bookEstore")
public class BookEstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookEstoreApplication.class, args);
	}

}
