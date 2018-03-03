package com.sada.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sada.Model.Course;
import com.sada.Model.Student;
public class ManyToOneInsertClient {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = factory.openSession();
		
		Student s1 = new Student();
		s1.setStudentId(1010);
		s1.setStudentName("aaa");
		s1.setStudentGrp("BTECH");
		
		Student s2 = new Student();
		s2.setStudentId(1011);
		s2.setStudentName("bbb");
		s2.setStudentGrp("MCA");
		
		Course c1 = new Course();
		c1.setCourseId(801);
		c1.setCourseName("java");
		c1.setDuration(150);
		
		Course c2 = new Course();
		c2.setCourseId(802);
		c2.setCourseName("oracle");
		c2.setDuration(100);
		
		List s = new ArrayList();
		s.add(c1);
		s.add(c2);
		s1.setCourse(s);
		s2.setCourse(s);
		
		
		Transaction tx = session.beginTransaction();
		session.save(s1);
		session.save(s2);
		tx.commit();
		
		session.close();
		factory.close();
	}
}
