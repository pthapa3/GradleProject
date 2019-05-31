package RestAPI;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookDAO {
	
	
	
	@Autowired
	BookRepository bookrepo;
	
	
	//Save a book
	
	public Book save (Book book) {
		return bookrepo.save(book);
		
	}
	
	//Get all books
	public Iterable <Book> getBooks(){
		
		return bookrepo.findAll();
		
	}
	
	//Get a book
	public Book getbook(Integer bookId) {
		
		return bookrepo.findById(bookId).get();
		
		
	}
	
	//Delete a book
	public void delete(Book book) {
		
		bookrepo.delete(book);
		
		
	}
	
	
   
	 
}
