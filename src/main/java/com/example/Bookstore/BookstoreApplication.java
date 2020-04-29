package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.Person;
import com.example.Bookstore.domain.UserRepository;
import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Action"));
			crepository.save(new Category("Romance"));
			crepository.save(new Category("Poetry"));
			
			brepository.save(new Book("Ernest Hemingway", "A Farewell to Arms", "1232323-21", "1929",crepository.findByName("Action").get(0)));
			brepository.save(new Book("George Orwell", "Animal Farm", "2212343-5", "1945", crepository.findByName("Fantasy").get(0)));	
			
			// Create users: admin/admin user/user reader/reader
			Person user1 = new Person("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@user.com", "USER");
			Person user2 = new Person("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@admin.com", "ADMIN");
			Person user3 = new Person("reader","$2a$10$YFPwD8WD1zuaeQ.1HNDL5.5TKJqXsrdDkL38il69.RLBifKSbSqSW", "reader@reader.com", "USER");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
