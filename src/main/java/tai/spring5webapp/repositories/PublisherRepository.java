package tai.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tai.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
