package com.sada.Model;
import java.io.Serializable;
public class Book implements Serializable {
	
	private int bookId;
	private String bookName;
	private double price;
	private int isbn;
	
	public Book() {
	}
	
	public Book(int bookId, String bookName, double price, int isbn) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.isbn = isbn;
	}
	
	public Book(int bookId, int isbn) {
		this.bookId = bookId;
		this.isbn = isbn;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
}
