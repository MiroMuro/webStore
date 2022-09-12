package com.example.Bookstore;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByAuthor(String lastName);

    
}