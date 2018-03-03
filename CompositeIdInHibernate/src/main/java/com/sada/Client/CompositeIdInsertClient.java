package com.sada.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.sada.Model.Book;
public class CompositeIdInsertClient {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Book b = new Book();
		b.setBookId(1);
		b.setIsbn(10111);
		b.setBookName("java");
		b.setPrice(3000.0);
		
		Transaction tx= session.beginTransaction();
		session.save(b);
		
		tx.commit();
		session.close();
		factory.close();
	}
}
