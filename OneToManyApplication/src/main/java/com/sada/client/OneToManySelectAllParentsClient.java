package com.sada.client;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Customer;
import com.sada.Model.Vendor;

public class OneToManySelectAllParentsClient {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		Query qry = session.createQuery("from Vendor v");
		List l = qry.list();
		Iterator it = l.iterator();
		while(it.hasNext()){
			Vendor v = (Vendor)it.next();
			System.out.println("parent details: "+v.getVendorId()+" "+v.getVendorName());
			Set s = v.getCustomers();
			Iterator it1 = s.iterator();
			while(it1.hasNext()){
				Customer c = (Customer)it1.next();
				System.out.println("Customer ID:"+c.getCustomerId());
				System.out.println("Customer Name: "+c.getCustomerName());
				System.out.println("Customer Address: "+c.getCustomerAddress());		
			}
		}
		
		session.close();
		factory.close();
	}
}
