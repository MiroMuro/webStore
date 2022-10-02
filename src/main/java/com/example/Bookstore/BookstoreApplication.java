package com.example.Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;
@SpringBootApplication
@EnableJpaRepositories
public class BookstoreApplication {
	@Autowired
	private UserRepository Urepo;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository,CategoryRepository crepository) {
	return (args) -> {
		 Logger logger=Logger.getLogger("global");

		crepository.save(new Category("Fantasy"));
		crepository.save(new Category("Sci-fi"));
		crepository.save(new Category("Horror"));

		repository.save(new Book("Harry Potter","J.K. Rowling","123abc",2000,"19,99", crepository.findByName("Fantasy")));
		repository.save(new Book("Persy Jackson", "Jack Daniels,","897asc89",2008,"5.90",crepository.findByName("Fantasy")));
		repository.save(new Book("Pokemon", "Pers. A. Ukko,","jd8sjs83",1997,"18.90",crepository.findByName("Horror")));
		
		Urepo.save(new User("user","$2a$10$Xgc5M1k2WNh4sw93qmgrM.Hc64iaifzro.ME8LjejMl.yyNOpGG6G","USER"));
		Urepo.save(new User("admin","$2a$10$oXYiJuvfs8hrvWUAIgbRbOvi1m60crb4n7GWs6ZLeb2HNc.ES9ENC","ADMIN"));
		
		
		};
	
		
	};
	}


