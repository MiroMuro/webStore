package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.web.BookController;

@SpringBootTest
class BookstoreApplicationTests {
	 Logger logger=Logger.getLogger("global");

	@Autowired
	private CategoryRepository crepository;
	@Autowired
	private BookController controller;
	@Autowired
	private BookRepository repository;
	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	@Test
	public void BookListLoads() throws Exception {
		assertThat(controller.bookListRest()).isNotNull();
	}
	@Test
	public void FindBookLoads() throws Exception {
		assertThat(controller.findBookRest((long) 6)).isNotNull();
	}
	@Test
	public void TestCreatingBook() throws Exception {
		Book kirja = new Book("Five Magis","Arthur Williams","A2D1-D123-BT77-66GG",1931,"19,99", crepository.findByName("Fantasy"));
		repository.save(kirja);
		assertThat(kirja.getId()).isNotNull();
	}
	@Test
	public void TestDeletingBook() throws Exception {
		List<Book> kirja = repository.findByTitle("Harry Potter");
		Book book = kirja.get(0); // Kirjan id on 4.
		repository.delete(book);
		assertThat(repository.findById((long) 4)).isEmpty();
	}
	@Test
	public void TestSearches() throws Exception {
		assertThat(repository.findByTitle("Pokemon")).isNotNull();
		assertThat(repository.findById((long) 5 )).isNotNull();
		assertThat(repository.findByAuthor("Jack Daniels")).isNotNull();
		assertThat(crepository.findByName("Fantasy")).isNotNull();
	}
	@Test
	void contextLoads() {
	}

}
