package com.sada.client;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Customer;
import com.sada.Model.Vendor;

public class OneToManySelectParentClient {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		Vendor v = (Vendor)session.get(Vendor.class,111);
		System.out.println("parent details: "+v.getVendorId()+" "+v.getVendorName());
		
		Set set = v.getCustomers();
		Iterator it = set.iterator();
		while(it.hasNext()){
			Customer c = (Customer)it.next();
			System.out.println("Customer ID:"+c.getCustomerId());
			System.out.println("Customer Name: "+c.getCustomerName());
			System.out.println("Customer Address: "+c.getCustomerAddress());
		}
	}
}
