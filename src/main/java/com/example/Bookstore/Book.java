package com.example.Bookstore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private String isbn;
	private String release;
	private String price;
	
	

// private String author;

// private String isbn;
public Book(){}

public Book(String title,String author,String isbn, String release, String price) {
	super();
	this.title= title;
	this.author=author;
	this.isbn = isbn;
	this.release = release;
	this.price= price;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id=id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getrelease() {
	return release;
}
public void setrelease(String release) {
	this.release = release;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
}
