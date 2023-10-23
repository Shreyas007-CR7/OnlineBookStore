package com.example.bookEstore.service;

import java.util.List;

import com.example.bookEstore.model.Book;

public interface BookService {
	List<Book> showAllBooks();
	List<Book> searchBookByName(String bookName);
	List<Book> searchBookByAuthor(String bookAuthor);
	int addBooks(Book book);
	void deleteBookByName(String name);
	int updateBooks(Book book,String name);
	boolean isBookNameExists(String name);
	
	
}
