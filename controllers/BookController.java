package com.ernesto.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ernesto.mvc.models.Book;
import com.ernesto.mvc.services.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/books/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "show.jsp";
	}
}

//List<Book> books = bookService.allBooks();
//model.addAttribute("books", books);
