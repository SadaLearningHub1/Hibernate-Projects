package com.sadalearninghub.GeneratorClassInHibernateUsingXMLConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sadalearninghub.GeneratorClassInHibernateUsingXMLConfig.pojo.Product;



public class ProductInsertClient {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		
		Product p = new Product();
		p.setProductName("MOTO");
		p.setPrice(500);
		
		Transaction tx = session.beginTransaction();
		session.save(p);
		
		tx.commit();
		
		session.close();
		factory.close();
	
	}
}
