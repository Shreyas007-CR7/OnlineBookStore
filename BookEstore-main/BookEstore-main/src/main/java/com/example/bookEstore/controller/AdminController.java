package com.example.bookEstore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bookEstore.model.Book;
import com.example.bookEstore.model.Customer;
import com.example.bookEstore.service.AdminService;
import com.example.bookEstore.service.BookService;
import com.example.bookEstore.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	
  
	@Autowired
	private AdminService adminService;
	@Autowired
	private BookService bookService;
	@Autowired
	private CustomerService custService;

	@RequestMapping("/admin")
	public String admin(Model model, HttpServletRequest request) {
		HttpSession session= request.getSession();
		String email=(String)session.getAttribute("email");
		if(email==null) {
			return "redirect:/login";
		}
		
		LOGGER.info("Sucessfully retuned Admin homepage");
		
		List<Book> bookList = bookService.showAllBooks();
		model.addAttribute("booklist",bookList);
		return "adminHome";
	}
	
	@RequestMapping(path="/adminhandler", method=RequestMethod.POST)
	public ResponseEntity<String> admin(
	        @RequestParam("email") String email,
	        @RequestParam("pass") String pass,
	        HttpServletRequest request
			) {
		  LOGGER.info("Adminhandler Running successfully");
		    Boolean rs = adminService.loginAdmin(email, pass);
		    if (rs) {
		        HttpSession session = request.getSession();
		        session.setAttribute("email", email);
		        return new ResponseEntity<>("Login successful", HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
		    }
		    
	}
	@RequestMapping("/adminLogin")
	public String adminLogin() {
		LOGGER.info("Sucessfully retuned Admin Login");
		return "adminLogin";
	}
   
	@RequestMapping(path="/addBooks", method=RequestMethod.POST)
	public String AddBooks(
			@RequestParam("barcode") String barcode, 
			@RequestParam("name") String name,
			@RequestParam("author") String author, 
			@RequestParam("price") double price, 
			@RequestParam("quantity") int quantity,
	        @RequestParam("image") String image, 
	        @RequestParam("bookdesc") String bookdesc,Model model)
	{
		
		 if (bookService.isBookNameExists(name)) {
		        model.addAttribute("nameError", "Book name already exists.");
		        return "addBook"; // Return to the addBook page with an error message
		    }
		 
		Book book= new Book(barcode, name, author, price, quantity, image, bookdesc);
		bookService.addBooks(book);
		
		return "redirect:/admin";
	}
	
	@RequestMapping("/addBookPage")
	public String AddBookPage() {
		LOGGER.info("Sucessfully retuned Add Book Page");
		return "addBook";
	}
	@RequestMapping(path = "/deleteBook", method = RequestMethod.POST)
	public String deleteBook(@RequestParam("bookName") String name) {
	    // Call a service method to delete the book by name
	    bookService.deleteBookByName(name);

	    return "redirect:/admin";
	}

	

	@RequestMapping("/deleteBookPage")
	public String deleteBookPage() {
		LOGGER.info("Sucessfully retuned Delete Book Page");
		return "deleteBook";
	}
    
	@RequestMapping("/updateBookPage")
	public String updatteBookPage() {
		LOGGER.info("Sucessfully retuned Update Book Page");
		return "updateBook";
	}
	@RequestMapping(path = "/updateBook", method = RequestMethod.POST)
	public String updateBook( 
			@RequestParam("name") String name,
			@RequestParam("price") double price, 
			@RequestParam("quantity") int quantity
	        ) {
		
		Book book= new Book(name,price,quantity);
		bookService.updateBooks(book,name);
		

	    return "redirect:/admin";
	}
	@RequestMapping("/showAllUsersPage")
	public String showAllCustomers(Model model) {
	    // Call a service method to retrieve a list of all users
	    List<Customer> customerList = custService.showAllUsers();

	    // Add the list of users to the model
	    model.addAttribute("customerlist", customerList);

	    return "showAllUsers";
	}
   

}
