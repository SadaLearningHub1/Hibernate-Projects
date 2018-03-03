package com.sadalearninghub.ApplicationInhibernateAnnotations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sadalearninghub.ApplicationInhibernateAnnotations.pojo.Product;



public class ProductInsertClient {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		
		Product p = new Product();
		p.setProductId(445);
		p.setProductName("LG");
		p.setPrice(100);
		
		Transaction tx = session.beginTransaction();
		session.save(p);
		
		tx.commit();
		
		Session session1 = factory.openSession();
		
		//Object o = session.get(Product.class, 444);
		Object o = session1.load(Product.class, 444);
		Product p1 = (Product)o;
		
		System.out.println("Product Id: "+p1.getProductId());
		System.out.println("Product Name : "+p1.getProductName());
		System.out.println("Price : "+p1.getPrice());
		
		session.close();
		factory.close();
	
	}
}
