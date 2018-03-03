package com.sada.client;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Person;
import com.sada.Model.Pname;
public class ComponentTestClientPri {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		Pname p = new Pname();
		p.setInitial('s');
		p.setFirstName("sada");
		p.setLastName("siva");
		Person per = new Person();
		per.setPersonId(111);
		per.setDate(new Date());
		per.setPname(p);
	
		Transaction tx = session.beginTransaction();
		session.save(per);
		
		tx.commit();
		
		session.close();
		factory.close();
	}
}
