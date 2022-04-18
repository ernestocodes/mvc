package com.ernesto.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ernesto.mvc.models.Book;
import com.ernesto.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// update a book

	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}

	// creates a book
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	// delete a book
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

}