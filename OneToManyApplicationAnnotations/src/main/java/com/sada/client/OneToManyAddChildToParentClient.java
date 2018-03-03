package com.sada.client;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Customer;
import com.sada.Model.Vendor;
public class OneToManyAddChildToParentClient {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		Vendor v = (Vendor)session.get(Vendor.class, 222);
		Set s = v.getCustomers();
		
		Customer c4 = new Customer();
		c4.setCustomerId(604);
		c4.setCustomerName("CTS");
		c4.setCustomerAddress("us");
		
		Transaction tx = session.beginTransaction();
		s.add(c4);
		tx.commit();
		
		session.close();
		factory.close();
	}

}
