package com.sada.client;

import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Course;
import com.sada.Model.Student;

public class ManyToManyDeleteParentClient {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		Student s = (Student)session.get(Student.class, 1001);
		Set set = s.getCourse();
		
		Course c= (Course)session.get(Course.class, 902);
		
		Transaction tx = session.beginTransaction();
		set.remove(c);
		tx.commit();
		
		session.close();
		factory.close();
	}
}
