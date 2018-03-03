package com.sada.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.sada.Model.Product;
public class ProductClientForTimestamp {
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx= session.beginTransaction();

		//insert the product with id 120 hear version is 0
		Product p1 = new Product();
		p1.setProductId(122);
		p1.setProductName("MOTO");
		p1.setPrice(2500);
		session.save(p1);
		tx.commit();

		Transaction tx1= session.beginTransaction();
		Object o = session.get(Product.class,121);
		Product p = (Product)o;
		p.setPrice(3000);
		session.update(p);
		tx1.commit();


		session.close();
		factory.close();
	}
}
