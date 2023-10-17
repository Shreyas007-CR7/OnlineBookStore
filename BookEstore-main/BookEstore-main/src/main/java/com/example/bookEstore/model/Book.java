package com.example.bookEstore.model;

public class Book {
	private String barcode;
    private String name;
    private String author;
    private double price;
    private int quantity;
    private String image;
    private String bookdesc;

    public Book(String barcode, String name, String author, double price, int quantity,String image,String bookdesc) {
        this.barcode = barcode;
        this.name = name;
        this.author = author;
        this.price=price;
        this.quantity = quantity;
        this.image=image;
    }

    public Book() {
        
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getBookdesc() {
		return bookdesc;
	}

	public void setBookdesc(String bookdesc) {
		this.bookdesc = bookdesc;
	}


	@Override
	public String toString() {
		return "Book [barcode=" + barcode + ", name=" + name + ", author=" + author + ", price=" + price + ", quantity="
				+ quantity + ", image=" + image + ", bookdesc=" + bookdesc + "]";
	}

	
}
