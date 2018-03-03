package com.sada.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.sada.Model.Customer;
public class UserDefinedGeneratorTest {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Customer c = new Customer();
		c.setCustomerName("sada");
		c.setCustomerAddress("HYD");
		
		Transaction tx= session.beginTransaction();
		
		session.save(c);
		
		tx.commit();
		session.close();
		factory.close();
	}
}
