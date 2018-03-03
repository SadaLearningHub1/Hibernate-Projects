package com.sada.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Customer;
import com.sada.Model.Vendor;
public class ManyToOneInsertClient {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		//Parent object
		Vendor v = new Vendor();
		v.setVendorId(222);
		v.setVendorName("IBM");
		
		//Child Object - 1
		Customer c1 = new Customer();
		c1.setCustomerId(601);
		c1.setCustomerName("INFY");
		c1.setCustomerAddress("HYD");
		
		//child Object-2
		Customer c2 = new Customer();
		c2.setCustomerId(602);;
		c2.setCustomerName("TCS");
		c2.setCustomerAddress("HYD");
		
		//Child Object - 3
		Customer c3 = new Customer();
		c3.setCustomerId(603);
		c3.setCustomerName("VERIZON");
		c3.setCustomerAddress("US");
		
		//add parent objects to child objects
		c1.setVendor(v);
		c2.setVendor(v);
		c3.setVendor(v);
		
		
		session.save(c1);
		session.save(c2);
		session.save(c3);
		
		tx.commit();
		
		session.close();
		factory.close();
	}
}
