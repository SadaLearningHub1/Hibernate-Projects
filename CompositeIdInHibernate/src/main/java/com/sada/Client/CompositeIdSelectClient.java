package com.sada.Client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sada.Model.Book;

public class CompositeIdSelectClient {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Book b = new Book();
		b.setBookId(1);
		b.setIsbn(10111);
		Object o = session.get(Book.class,b);
		Book b1 = (Book)o;
		System.out.println("Book name is: "+b1.getBookName());
		System.out.println("Book price is: "+b1.getPrice());
		session.close();
		factory.close();
	
	}

}
