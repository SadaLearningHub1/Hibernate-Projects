package com.sadalearninghub.oneToManyApplicationUsingMap;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sadalearninghub.oneToManyApplicationUsingMap.model.Dealer;
import com.sadalearninghub.oneToManyApplicationUsingMap.model.Product;
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
		
		Map map = new HashMap();
		map.put("k1", p);
		map.put("k2", p1);
		map.put("k3", p2);
		
		d.setProducts(map);
		
		Transaction tx = session.beginTransaction();
		session.save(d);
		tx.commit();
		
		session.close();
		factory.close();
	}
}
