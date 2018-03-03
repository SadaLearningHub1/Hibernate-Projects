package com.sada.client;


import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Employee;
public class HQLSelectClient {
	private static Scanner s;

	public static void main(String[] args) {
				
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
        
		Session session = factory.openSession();
		
		//Approch-1
		Query qry1 = session.createQuery("from Employee e");
		List<Object> list1 = qry1.list();
		Iterator<Object> it1 = list1.iterator();
		while(it1.hasNext()){
			Employee e = (Employee)it1.next();
			System.out.println("Emp no: "+e.getEmployeeId());
			System.out.println("Emp name: "+e.getEmployeeName());
			System.out.println("Emp sal: "+e.getEmployeeSal());
			System.out.println("Deptno: "+e.getDeptNumber());
			System.out.println("=============================");
		}
		
		//Approch-2
		Query qry2 = session.createQuery("select e.employeeName, e.employeeSal from Employee e where e.deptNumber=:p1");
		s = new Scanner(System.in);
		System.out.println("Enter Department number");
		int dno = s.nextInt();
		qry2.setParameter("p1", dno);
		List<Object> list2 = qry2.list();
		Iterator<Object> it2 = list2.iterator();
		while(it2.hasNext()){
			Object obj[] = (Object[])it2.next();
			System.out.println(obj[0]+"     "+obj[1]);
		}
		
		//Approch-3
		Query qry3 = session.createQuery("select e.employeeName from Employee e where e.deptNumber=2");
		List<Object> list3 = qry3.list();
		Iterator<Object> it3 = list3.iterator();
		while(it3.hasNext()){
			String str = (String)it3.next();
			System.out.println("Employee NAme : "+ str);
		}
		
		session.close();
		factory.close();
	}
}
