package com.sadalearninghub.ReadAndSelectObjectInHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sadalearninghub.ReadAndSelectObjectInHibernate.pojo.Product;

public class ProductLoadClient {
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		
		//Object o = session.get(Product.class, 444);
		Object o = session.load(Product.class, 444);
		Product p = (Product)o;
		
		System.out.println("Product Id: "+p.getProductId());
		System.out.println("Product Name : "+p.getProductName());
		System.out.println("Price : "+p.getPrice());
		
		session.close();
		factory.close();
		
	}
}
