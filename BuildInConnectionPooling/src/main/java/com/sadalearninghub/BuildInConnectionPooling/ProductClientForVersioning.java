package com.sadalearninghub.BuildInConnectionPooling;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sadalearninghub.BuildInConnectionPooling.pojo.Product;

public class ProductClientForVersioning {
	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx= session.beginTransaction();

		//insert the product with id 120 hear version is 0
		Product p1 = new Product();
		p1.setProductId(122);
		p1.setProductName("LG");
		p1.setPrice(2500);
		session.save(p1);
		tx.commit();

		//updating the product id 120 with sal 5000 now version is 2
		Transaction tx1= session.beginTransaction();
		Object o = session.get(Product.class,121);
		Product p = (Product)o;
		p.setPrice(5000);
		session.update(p);
		tx1.commit();


		session.close();
		factory.close();
	}
}
