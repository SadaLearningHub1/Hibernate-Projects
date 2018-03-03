package com.sada.client;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
public class HQLNonSelectClient {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		Query qry = session.createQuery("insert into TestEmployee(employeeId, employeeName) select e.employeeId, e.employeeName from Employee e");
		Transaction tx = session.beginTransaction();
		int k = qry.executeUpdate();
		tx.commit();
		System.out.println(k+"objects are inserted");
		
		Query qry1 = session.createQuery("update Employee e set e.employeeSal=0000 where e.deptNumber=2");
		Transaction tx1 = session.beginTransaction();
		int i = qry1.executeUpdate();
		tx1.commit();
		System.out.println(i+" objects are updated");
		
		
		session.close();
		factory.close();
	}
}
