package RestAPI;



import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import RestAPI.Book;


@RestController    
@RequestMapping(path="/home") 
public class BookController {
	
	@Autowired 
	private BookDAO bookDAO;

	
	@GetMapping(path="/books", produces = {"application/json"})
	public @ResponseBody Iterable <Book> getAllBooks() {
		
		return bookDAO.getBooks();
	}
	
	@GetMapping(path="/books/{id}") 
	public ResponseEntity<Book> addNewUser (@PathVariable(value="id") Integer bookId) {
		
		Book book = bookDAO.getbook(bookId);
		
		if (book==null) {
			return ResponseEntity.notFound().build();
			
		}
		
		return ResponseEntity.ok().body(book);
		
	}



	@PostMapping(path="/books")
	public Book addBook (@Valid @RequestBody Book book) {
		
		return bookDAO.save(book);
	}
	
	
	@PutMapping(path="/books/{id}")
	public ResponseEntity<Book> updateBooks (@PathVariable(value="id") Integer bookId, 
			@Valid @RequestBody Book newBook){
		
		Book book = bookDAO.getbook(bookId);
		if (book==null) {
			return ResponseEntity.notFound().build();
			
		}
		
		book.setAuthor(newBook.getAuthor());
		book.setTitle(newBook.getTitle());
		book.setPageCount(newBook.getPageCount());
		book.setComments(newBook.getComments());
		
		Book updatedBook = bookDAO.save(book);
		
		return ResponseEntity.ok().body(updatedBook);
		
	}
	
	@DeleteMapping(path="books/{id}")
	public ResponseEntity<?> deleteBooks (@PathVariable(value="id") Integer bookId){
		
		Book book = bookDAO.getbook(bookId);
		if (book==null) {
			return ResponseEntity.notFound().build();
			
		}
		
		bookDAO.delete(book);
		
		return ResponseEntity.ok().body(bookDAO.getBooks());
		
		
	}
	
}
