package com.sadalearninghub.DeleteAnObjectInHibernateUsingXmlConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sadalearninghub.DeleteAnObjectInHibernateUsingXmlConfig.pojo.Product;

public class DeleteAnObjectClient {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		
		SessionFactory factory = conf.buildSessionFactory();
		
		
		System.out.println("Deleting the object Approch-1 : ");
		Session session = factory.openSession();
		Product p = new Product();
		p.setProductId(444);
		Transaction tx = session.beginTransaction();
		session.delete(p);
		tx.commit();
		System.out.println("Product is Deleted");
		
		System.out.println("------------------------------");
		
		System.out.println("Deleting the object Approch-2 : ");
		Session session1 = factory.openSession();
		Object o = session1.load(Product.class, 445);
		Product p1 = (Product)o;
		Transaction tx1 = session1.beginTransaction();
		session1.delete(p1);
		tx1.commit();
		System.out.println("Product is upadted");
		
		
		session.close();
		session1.close();
		factory.close();

	}

}
