package com.example.Bookstore.web;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

import org.springframework.stereotype.Controller;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/book/{id}",method= RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return repository.findById(bookId);
	}
	
	@RequestMapping(value="/books",method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest(){
		return (List<Book>)repository.findAll();
	}
	
	
	@RequestMapping(value="/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
	
		return "redirect:booklist";
		
	}
	@RequestMapping(value="delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
		
	}
	@RequestMapping(value="/editbook/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model, Book book) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());

		return "editbook";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	@RequestMapping(value="/logout")
	public String logout() {
		return "logout";
	}
	

}

