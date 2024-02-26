package com.api.book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


@Component
public class BookService {
	
	private static List<Book> list=new ArrayList<>();
	
	static{
		list.add(new Book(12,"Shelock homes","RD junior" ));
		list.add(new Book(13,"Mannat","SRK" ));
		list.add(new Book(14,"Galaxy","Salman" ));
	}
	
	
	//get all books 
	
	public List<Book> getAllBooks()
	{
		return list;
	}
	
	public Book getBookById(int id)
	{
		Book book= null;
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
	    return book;
	 
	}
	
	public Book addBook(Book b)
	{
		list.add(b);
		return b;
	}
	
	public void deleteBook(int id)
	{
		list =list.stream().filter(book->book.getId()!=id).
			collect(Collectors.toList());	
	}
	
	public void updateBook(Book book,int id)
	{
		list=list.stream().map(b->{
			if(b.getId()==id)
			{
				b.setAuthor(book.getAuthor());
				b.setTitle(book.getTitle());
			}
			return b;
		}).collect(Collectors.toList());
		
	}
	
	
	

}
