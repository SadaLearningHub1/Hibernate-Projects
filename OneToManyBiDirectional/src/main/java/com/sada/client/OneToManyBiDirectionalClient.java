package com.sada.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Customer;
import com.sada.Model.Vendor;
public class OneToManyBiDirectionalClient {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		//Parent object
		Vendor v = new Vendor();
		v.setVendorId(111);
		v.setVendorName("IBM");
		
		//Child Object - 1
		Customer c1 = new Customer();
		c1.setCustomerId(501);
		c1.setCustomerName("INFY");
		c1.setCustomerAddress("HYD");
		
		//child Object-2
		Customer c2 = new Customer();
		c2.setCustomerId(502);;
		c2.setCustomerName("TCS");
		c2.setCustomerAddress("HYD");
		
		//Child Object - 3
		Customer c3 = new Customer();
		c3.setCustomerId(503);
		c3.setCustomerName("VERIZON");
		c3.setCustomerAddress("US");
		
		//ManyToOne
		c1.setVendor(v);
		c2.setVendor(v);
		c3.setVendor(v);
		
		//OneToMany
		Set s = new HashSet();
		s.add(c1);
		s.add(c2);
		s.add(c3);
		v.setCustomers(s);
		
		Transaction tx = session.beginTransaction();
		
		session.save(c1);
		session.save(c2);
		session.save(c3);
		
		//or
		
		//session.save(v);
		
		tx.commit();
		
		session.close();
		factory.close();
	}
}
