package com.sada.client;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Employee;
public class NamedQueryClient {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();

		//Named HQL Query
		Query qry = session.getNamedQuery("q1");
		qry.setParameter(0,1);
		List list = qry.list();
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println("Result From Named HQL Query");
			Employee e = (Employee)it.next();
			System.out.println("EmployeeId: "+e.getEmployeeId());
			System.out.println("Employee Name: "+e.getEmployeeName());
			System.out.println("Employee salary: "+e.getEmployeeSal());
			System.out.println("Department number: "+e.getDeptNumber());
			System.out.println("=========================");
		}
		
		
		//Named SQL Query
		Query qry1 = session.getNamedQuery("q2");
		qry1.setParameter(0,2);
		List list1 = qry1.list();
		Iterator it1 = list1.iterator();
		while(it1.hasNext()){
			System.out.println("Result From Native SQL Named query Query");
			Object e[] = (Object[])it1.next();
			System.out.println("EmployeeId: "+e[0]);
			System.out.println("Employee Name: "+e[1]);
			System.out.println("Employee salary: "+e[2]);
			System.out.println("Department number: "+e[3]);
			System.out.println("=========================");
		}

		session.close();
		factory.close();
	}
}
