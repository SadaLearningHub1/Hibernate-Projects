package com.sada.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sada.Model.Book;
import com.sada.Model.BookComposite;
public class CompositeIdInsertClient {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		BookComposite bc= new BookComposite();
		bc.setBookId(103);
		bc.setIsbn(11114);
		
		Book b = new Book();
		b.setBookcomposite(bc);
		b.setAuthor("BAA");
		b.setPrice(4000);
		
		Transaction tx= session.beginTransaction();
		session.save(b);
		
		tx.commit();
		
		session.close();
		factory.close();
	}
}
