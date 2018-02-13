package tai.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tai.spring5webapp.model.Author;
import tai.spring5webapp.model.Book;
import tai.spring5webapp.repositories.AuthorRepository;
import tai.spring5webapp.repositories.BookRepository;

@Component  // declare bean definition for DevBootstrap
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    // Dependency Injection
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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
        Author steve = new Author("Steve", "McConnell");
        Book cc = new Book("Code Complete", "0735619670", "Microsoft Press");
        steve.getBooks().add(cc);
        cc.getAuthors().add(steve);
        authorRepository.save(steve);
        bookRepository.save(cc);

        // Joshua Bloch
        Author joshua = new Author("Joshua", "Bloch");
        Book ej = new Book("Effective Java", "0321356683", "Addison-Wesley");
        joshua.getBooks().add(ej);
        ej.getAuthors().add(joshua);
        authorRepository.save(joshua);
        bookRepository.save(ej);

    }
}
