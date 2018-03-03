package com.sada.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Course;
import com.sada.Model.Student;

public class ManyToManyInsertClient {
	public static void main(String[] args) {


		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		Set<Course> courses = new HashSet<Course>();
		courses.add(new Course("AAA"));
		courses.add(new Course("BBBB"));

		Student student1 = new Student("ABC", courses);
		Student student2 = new Student("DEF", courses);
		
		Transaction tx = session.beginTransaction();
		session.save(student1);
		session.save(student2);
		tx.commit();
		
		session.close();
		factory.close();
	
	}
}
