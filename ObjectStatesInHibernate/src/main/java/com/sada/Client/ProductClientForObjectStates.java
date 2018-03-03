package com.sada.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.sada.Model.Product;
public class ProductClientForObjectStates {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		Product p = new Product(333,"NOKIA",4000);
		//Hear p is transient state
		Transaction tx= session.beginTransaction();
		session.save(p);//Hear p is persistent state
		p.setPrice(5500);//Effected on database, because p is in persistent state.
		tx.commit();
		session.close();
		p.setPrice(6500);//p is in detached state so changees is not effected.
		factory.close();
	}
}
