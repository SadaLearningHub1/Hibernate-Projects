package com.sadalearninghub.ApplicationInhibernateAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sadalearninghub.ApplicationInhibernateAnnotations.pojo.Product;



public class ProductSessionCacheClient {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		
		SessionFactory factory = conf.buildSessionFactory();
		Session session1 = factory.openSession();
		Session session2 = factory.openSession();
		
		//First time in session1 so object is loaded from DB
		Object o = session1.get(Product.class, 444);
		Product p = (Product)o;
		System.out.println("Product Id: "+p.getProductId());
		System.out.println("Product Id: "+p.getProductName());
		System.out.println("Product Id: "+p.getPrice());
		
		System.out.println("===============================");
		
		//Second time in session1 so object is loaded from Cache
		Object o1 = session1.get(Product.class, 444);
		Product p1 = (Product)o1;
		System.out.println("Product Id: "+p1.getProductId());
		System.out.println("Product Id: "+p1.getProductName());
		System.out.println("Product Id: "+p1.getPrice());
		System.out.println("===============================");
		
		//Third time in session2 so object is loaded from DB
		Object o2 = session2.get(Product.class, 444);
		Product p2 = (Product)o2;
		System.out.println("Product Id: "+p2.getProductId());
		System.out.println("Product Id: "+p2.getProductName());
		System.out.println("Product Id: "+p2.getPrice());
		System.out.println("===============================");
		
		
		session1.evict(p1);
		//Fifth time in session1 so object is loaded from DB because object is clear from session1 by using evict()
		Object o3 = session1.get(Product.class, 444);
		Product p3 = (Product)o3;
		System.out.println("Product Id: "+p3.getProductId());
		System.out.println("Product Id: "+p3.getProductName());
		System.out.println("Product Id: "+p3.getPrice());
		System.out.println("===============================");
		
		session1.clear();
		
		session1.close();
		session2.close();
		factory.close();
		
		

	}

}
