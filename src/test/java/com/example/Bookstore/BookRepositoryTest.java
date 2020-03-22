package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository brepository;

    @Test
    public void findByAuthorShouldReturnBook() {
        List<Book> books = brepository.findByAuthor("Ernest Hemingway");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("A Farewell to Arms");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Edgar Allan Poe", "The Raven", "1559211784", "1845", new Category("Horror"));
    	brepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
    
    @Test
    public void deleteBook() {
    	List <Book> books = brepository.findByAuthor("George Orwell");
    	brepository.deleteById(books.get(0).getId());
    	assertThat(books.isEmpty());
    }    
}

