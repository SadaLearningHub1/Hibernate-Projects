package com.sadalearninghub.UpdatingAnObjectUsingHibernateInAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sadalearninghub.UpdatingAnObjectUsingHibernateInAnnotations.pojo.Product;



public class UpdatingAnObjectClient {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		
		SessionFactory factory = conf.buildSessionFactory();
		
		
		System.out.println("Updating the object Approch-1 : ");
		Session session = factory.openSession();
		Product p = new Product();
		p.setProductId(444);
		p.setProductName("ccccc");
		p.setPrice(10034);
		Transaction tx = session.beginTransaction();
		session.update(p);
		System.out.println("Product is upadted");
		tx.commit();
		
		System.out.println("------------------------------");
		
		System.out.println("Updating the object Approch-2 : ");
		Session session1 = factory.openSession();
		Object o = session1.load(Product.class, 445);
		Product p1 = (Product)o;
		p1.setProductName("ddd");
		p1.setPrice(980);
		Transaction tx1 = session1.beginTransaction();
		session1.update(p1);
		System.out.println("Product is upadted");
		tx1.commit();
		
		session.close();
		session1.close();
		factory.close();

	}

}
