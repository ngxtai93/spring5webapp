package tai.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tai.spring5webapp.model.Author;

// Using Repository to do persistence

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
