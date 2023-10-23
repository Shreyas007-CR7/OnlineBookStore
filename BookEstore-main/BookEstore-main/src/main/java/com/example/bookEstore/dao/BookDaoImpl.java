package com.example.bookEstore.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.bookEstore.model.Book;
import com.example.bookEstore.dao.BookMapper;

@Repository
public class BookDaoImpl implements BookDao {
	private final static String SQL_SRCH_BOOK = "select * from book";
	private final static String SQL_ADD_Books = "INSERT INTO book (barcode,bookname, author, price, quantity, image, bookdesc) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final static String SQL_Delete_Books="DELETE FROM book WHERE bookname = ?";
	private final static String SQL_UPDATE_BOOK = "UPDATE book SET price = ?, quantity = ? where bookname=?";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Book> searchBookByName(String bookName) {
		List <Book> books = jdbcTemplate.query(SQL_SRCH_BOOK, new BookMapper());
	      return books;
	}
	@Override
	public List<Book> searchBookByAuthor(String bookAuthor) {
		List <Book> books = jdbcTemplate.query(SQL_SRCH_BOOK, new BookMapper());
	      return books;
	}
	@Override
	public List<Book> showAllBooks() {
		List <Book> books = jdbcTemplate.query(SQL_SRCH_BOOK, new BookMapper());
	      return books;
	}
	@Override
	public int addBooks(Book book) {
		int noOfRow = jdbcTemplate.update(SQL_ADD_Books,book.getBarcode(),book.getName(),book.getAuthor(),book.getPrice(),book.getQuantity(),book.getImage(),book.getBookdesc());

		return noOfRow;
	}
	@Override
	public void deleteBookByName(String name) {
		 int rowsAffected = jdbcTemplate.update(SQL_Delete_Books, name);
		 }
	@Override
	public int updateBooks(Book book,String name) {
		int no=jdbcTemplate.update(SQL_UPDATE_BOOK,book.getPrice(),book.getQuantity(),name);
		
     return no;
     
	}
	@Override
	public boolean isBookNameExists(String name) {
		String sql = "SELECT COUNT(*) FROM book WHERE bookname = ?";
	    int count = jdbcTemplate.queryForObject(sql, Integer.class, name);

	    return count > 0;
	}
	
	   
	}
	

	


