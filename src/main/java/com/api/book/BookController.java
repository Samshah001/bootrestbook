package com.api.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	/*
	 * @GetMapping("/books") public Book getBooks() { Book book=new Book();
	 * book.setId(124); book.setTitle("Sameer Book"); book.setAuthor("Sameer Shah");
	 * 
	 * return book;
	 * 
	 * }
	 */
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		return this.bookService.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
		Book b=this.bookService.addBook(book);
		return b;
		 
	}
	
	@DeleteMapping("/books/{bookid}")
	public void deleteBook(@PathVariable("bookid")int bookid)
	{
       this.bookService.deleteBook(bookid);
		
	}
	
	
	@PutMapping("/books/{bookid}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookid")int bookid)
	{
       this.bookService.updateBook(book,bookid);
       return book;
		
	}
	
	
	

}
