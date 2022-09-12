package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
@SpringBootApplication
@EnableJpaRepositories
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
	return (args) -> {
		repository.save(new Book("Harry Potter","J.K. Rowling","123abc",2000,"19,99"));
		for(Book book: repository.findAll()) {
			System.out.println(book);
		};
	
		
	};
	}

}
