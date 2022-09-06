package com.example.Bookstore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
	@RequestMapping("/index")
	public String bookStore(Model model) {
		return "index";
	}

}
