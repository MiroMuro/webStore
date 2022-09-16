package com.example.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private String isbn;
	private Integer release;
	private String price;

	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;
	
	

// private String author;

public Book(){}

public Book(String title,String author,String isbn, Integer release, String price, Category category) {
	super();
	this.title= title;
	this.author=author;
	this.isbn = isbn;
	this.release = release;
	this.price= price;
	this.category = category;
	
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
public Integer getRelease() {
	return release;
}
public void setRelease(Integer release) {
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
	
}public Category getCategory() {
	return this.category;
	
}public void setCategory(Category category) {
	this.category = category;
}
}
