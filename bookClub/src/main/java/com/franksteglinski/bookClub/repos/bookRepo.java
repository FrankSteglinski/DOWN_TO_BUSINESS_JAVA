package com.franksteglinski.bookClub.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.franksteglinski.bookClub.models.Book;

@Repository
public interface bookRepo extends CrudRepository<Book, Long> {

	List<Book> findAll();
}
