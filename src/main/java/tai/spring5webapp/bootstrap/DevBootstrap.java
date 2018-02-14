package tai.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tai.spring5webapp.model.Author;
import tai.spring5webapp.model.Book;
import tai.spring5webapp.model.Publisher;
import tai.spring5webapp.repositories.AuthorRepository;
import tai.spring5webapp.repositories.BookRepository;
import tai.spring5webapp.repositories.PublisherRepository;

@Component  // declare bean definition for DevBootstrap
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    // Dependency Injection
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent cre) {
        initData();
    }

    /**
     * Initialize data on startup
     */
    private void initData() {
        // Steve McConnell
        Publisher microsoftPress = new Publisher("Microsoft Press", "Chicago, IL");
        publisherRepository.save(microsoftPress);

        Author steve = new Author("Steve", "McConnell");
        Book cc = new Book("Code Complete", "0735619670");
        cc.setPublisher(microsoftPress);
        steve.getBooks().add(cc);
        cc.getAuthors().add(steve);


        authorRepository.save(steve);
        bookRepository.save(cc);


        // Joshua Bloch
        Publisher addisonWesley = new Publisher("Addison-Wesley", "New York, NY");
        publisherRepository.save(addisonWesley);
        Author joshua = new Author("Joshua", "Bloch");
        Book ej = new Book("Effective Java", "0321356683");
        joshua.getBooks().add(ej);
        ej.getAuthors().add(joshua);
        ej.setPublisher(addisonWesley);
        authorRepository.save(joshua);
        bookRepository.save(ej);

    }
}
