package com.franksteglinski.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franksteglinski.bookClub.models.Book;
import com.franksteglinski.bookClub.repos.bookRepo;

@Service
public class BookService {

	@Autowired
	private bookRepo bookRepo;

//	READ ALL
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

//	CREATE
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}

//	READ ONE
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);

	//With ternary:
		//return optionalBook.isPresent() ? optionalBook.get() : null;

	//Alternately:
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
//	UPDATE
	public Book updateBook(Book b) {
		Book updatedBook = bookRepo.save(b);
		return updatedBook;
	}

//	DELETE
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}

}
