package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }



    @Override
    public void run(String... args) throws Exception {


        System.out.println("Started in Bootstrap");
        Publisher publisher =new Publisher();
        publisher.setName("Karoon");
        publisher.setCity("Tehran");
        publisher.setState("Tehran");

        publisherRepository.save(publisher);


        Author hoss=new Author("Hoss","Ghodrati");
        Book book1=new Book("Domain Driven Design","123");
        hoss.getBooks().add(book1);
        book1.getAuthors().add(hoss);

        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);


        authorRepository.save(hoss);
        bookRepository.save(book1);
        publisherRepository.save(publisher);

        Author sareh=new Author("Sareh","Keshani");
        Book book2=new Book("J2EE Development without EJB","345");

        sareh.getBooks().add(book2);
        book2.getAuthors().add(sareh);

        book2.setPublisher(publisher);
        publisher.getBooks().add(book2);

        authorRepository.save(sareh);
        bookRepository.save(book2);
        publisherRepository.save(publisher);



        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher Number of books: "+publisher.getBooks().size());




    }
}
