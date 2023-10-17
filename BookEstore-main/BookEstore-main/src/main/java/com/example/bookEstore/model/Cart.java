package com.example.bookEstore.model;

public class Cart {
	private String bookname;
	private String author;
	private double price;
	private int quantity;
	private String email;
	 private String image;
	 private String bookdesc;
	
	public Cart() {
		
	}

	public Cart(String bookname, String author, double price, int quantity, String email,String image,String bookdesc) {
		super();
		this.bookname = bookname;
		this.author = author;
		this.price = price;
		this.quantity = quantity;
		this.email = email;
		this.image=image;
		this.bookdesc=bookdesc;
		
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBookdesc() {
		return bookdesc;
	}

	public void setBookdesc(String bookdesc) {
		this.bookdesc = bookdesc;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Cart [bookname=" + bookname + ", author=" + author + ", price=" + price + ", quantity=" + quantity
				+ ", email=" + email + ", image=" + image + ", bookdesc=" + bookdesc + "]";
	}

	
}
