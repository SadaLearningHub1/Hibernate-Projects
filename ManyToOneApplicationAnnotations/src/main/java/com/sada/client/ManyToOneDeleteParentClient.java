package com.sada.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Customer;

public class ManyToOneDeleteParentClient {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		Customer c =(Customer)session.get(Customer.class, 503);
		
		Transaction tx = session.beginTransaction();
		session.delete(c);
		tx.commit();
		
		session.close();
		factory.close();
	}
}
