package RestAPI;

import org.springframework.data.repository.CrudRepository;
import RestAPI.Book;

public interface BookRepository extends CrudRepository <Book, Integer> {

}