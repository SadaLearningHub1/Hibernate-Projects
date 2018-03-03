package com.sada.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Dealer;
import com.sada.Model.Product;
public class OneToManyInsertClient {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		//Parent object
		Dealer d = new Dealer();
		d.setDealerId(102);
		d.setDealerName("ABC");
			
		//Child Object - 1
		Product p = new Product();
		p.setProductId(903);
		p.setProductName("X");
		p.setPrice(2000);
		
		//child Object-2
		Product p1 = new Product();
		p1.setProductId(904);
		p1.setProductName("Y");
		p1.setPrice(3000);
		
		//Child Object - 3
		Product p2 = new Product();
		p2.setProductId(905);
		p2.setProductName("Z");
		p2.setPrice(4000);
		
		List list = new ArrayList();
		list.add(p);
		list.add(p1);
		list.add(p2);
		
		d.setProducts(list);
		
		Transaction tx = session.beginTransaction();
		session.save(d);
		tx.commit();
		
		session.close();
		factory.close();
	}
}
