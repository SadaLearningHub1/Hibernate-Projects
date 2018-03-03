package com.sada.client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.sada.Model.Product;
public class ProxoolTest {
	public static void main(String[] args) {
		//step-1
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		//step-2
		SessionFactory factory = conf.buildSessionFactory();
		//step-3
		Session session = factory.openSession();
		//pojo class object
		Product p = new Product();
		p.setProductId(141);
		p.setProductName("LG");
		p.setPrice(9000);
		//step-4
		Transaction tx = session.beginTransaction();
		//step-5
		session.save(p);
		//step-6
		tx.commit();
		System.out.println("Product object insert successfully");
		//step-7
		session.close();
		//step-8
		factory.close();
	}
}
