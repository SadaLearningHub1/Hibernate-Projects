package com.sada.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.License;
import com.sada.Model.Person;
public class OneToOneInsertClientForegn {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		//Person object
		Person p = new Person();
		p.setPersonId(1101);
		p.setPersonName("ABC");
		
		//License object
		License l = new License();
		l.setLicenseId(1001);
		l.setExpireDate(new Date());
		l.setIssuedDate(new Date());
		l.setPerson(p);
		
		
		Transaction tx = session.beginTransaction();
		session.save(l);
		tx.commit();
		
		session.close();
		factory.close();
	}
}
