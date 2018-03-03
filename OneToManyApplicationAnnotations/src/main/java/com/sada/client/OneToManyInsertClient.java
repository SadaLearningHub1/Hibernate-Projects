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
public class OneToManyInsertClient {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		//Parent object
		Vendor v = new Vendor();
		v.setVendorId(222);
		v.setVendorName("Infosys");
		
		//Child Object - 1
		Customer c1 = new Customer();
		c1.setCustomerId(601);
		c1.setCustomerName("HSBC");
		c1.setCustomerAddress("HYD");
		
		//child Object-2
		Customer c2 = new Customer();
		c2.setCustomerId(602);;
		c2.setCustomerName("SBI");
		c2.setCustomerAddress("HYD");
		
		//Child Object - 3
		Customer c3 = new Customer();
		c3.setCustomerId(603);
		c3.setCustomerName("AndraBank");
		c3.setCustomerAddress("US");
		
		Set s = new HashSet();
		s.add(c1);
		s.add(c2);
		s.add(c3);
		v.setCustomers(s);
		
		Transaction tx = session.beginTransaction();
		session.save(v);
		tx.commit();
		
		session.close();
		factory.close();
	}
}
