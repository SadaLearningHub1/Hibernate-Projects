package com.sada.Model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class Book {
	@EmbeddedId
	private BookComposite bookcomposite;
	
	@Column(name="BOOKNAME", length=20)
	private String author;
	
	@Column(name="PRICE", length=20)
	private double price;

	public Book(BookComposite bookcomposite, String author, double price) {
		super();
		this.bookcomposite = bookcomposite;
		this.author = author;
		this.price = price;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(BookComposite bookcomposite) {
		super();
		this.bookcomposite = bookcomposite;
	}

	public BookComposite getBookcomposite() {
		return bookcomposite;
	}

	public void setBookcomposite(BookComposite bookcomposite) {
		this.bookcomposite = bookcomposite;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
