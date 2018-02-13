package tai.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tai.spring5webapp.model.Book;

// Using Repository to do persistence

public interface BookRepository extends CrudRepository<Book, Long> {
}
