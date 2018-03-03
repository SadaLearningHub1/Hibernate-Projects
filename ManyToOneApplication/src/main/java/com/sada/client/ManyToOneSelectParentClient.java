package com.sada.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Customer;
import com.sada.Model.Vendor;

public class ManyToOneSelectParentClient {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		Customer c = (Customer)session.get(Customer.class, 501);
		System.out.println(c.getCustomerName()+"    "+c.getCustomerAddress());
		
		Vendor v = c.getVendor();
		System.out.println(v.getVendorId()+"    "+v.getVendorName());
	}
}
