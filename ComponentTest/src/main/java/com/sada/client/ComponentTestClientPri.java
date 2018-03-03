package com.sada.client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Address;
import com.sada.Model.Student;
public class ComponentTestClientPri {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		Address addr = new Address();
		addr.setHno(121);
		addr.setStreet("ABC");
		addr.setCity("tenali");
		
		Student s = new Student();
		s.setStudentId(122);
		s.setStudentName("XYZ");
		s.setAddress(addr);
		
		
		Transaction tx = session.beginTransaction();
		session.save(s);
		
		tx.commit();
		
		session.close();
		factory.close();
	}
}
