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

public class ManyToManyAddingChild {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		Session session = factory.openSession();
		
		Student stu=(Student)session.get(Student.class, 1001);
		Set s = stu.getCourse();
		
		Course c3 = new Course();
		c3.setCourseId(903);
		c3.setCourseName("cpp");
		c3.setDuration(60);
		
		Transaction tx = session.beginTransaction();
		s.add(c3);
		tx.commit();
		
		session.close();
		factory.close();
	}
}
