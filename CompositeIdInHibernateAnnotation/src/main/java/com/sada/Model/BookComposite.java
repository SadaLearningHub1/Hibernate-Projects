package com.sada.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookComposite implements Serializable {
	@Column(name="BOOKID", length=10)
	private int bookId;
	
	@Column(name="ISBN", length=10)
	private int isbn;

	public BookComposite(int bookId, int isbn) {
		super();
		this.bookId = bookId;
		this.isbn = isbn;
	}

	public BookComposite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookComposite(int bookId) {
		super();
		this.bookId = bookId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	

}
