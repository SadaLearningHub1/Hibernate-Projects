package com.sada.client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Employee;
public class NativeSQLSelectClient {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		//If we want to read the full rows of employee table from database then the code is like the following.
		SQLQuery qry1 = session.createSQLQuery("select * from EMPLOYEE");
		List list1 = qry1.list();
		Iterator it1 = list1.iterator();
		while(it1.hasNext()){
			Object obj[] = (Object[])it1.next();
			System.out.println(obj[0]+"  "+obj[1]+"  "+obj[2]+"  "+obj[3]);
		}
		
		//While reading completed row of a table, we can inform the hibernate that convert each row of ResulSet into a pojo class object by making the query object as an entity query object.
		SQLQuery qry2 = session.createSQLQuery("select * from EMPLOYEE");
		qry2.addEntity(Employee.class);
		List list2 = qry2.list();
		Iterator it2 = list2.iterator();
		while(it2.hasNext()){
			Employee e = (Employee)it2.next();
			System.out.println("EmployeeId: "+e.getEmployeeId());
			System.out.println("Employee Name: "+e.getEmployeeName());
			System.out.println("Employee salary: "+e.getEmployeeSal());
			System.out.println("Department number: "+e.getDeptNumber());
		}
		
		//When reading a partial values of a table , hibernate converts each row of Resltset object into object[].
		SQLQuery qry3 = session.createSQLQuery("select EMPLOYEEID, EMPLOYEENAME  from EMPLOYEE");
		List list3 = qry3.list();
		Iterator it3 = list3.iterator();
		while(it3.hasNext()){
			Object obj[] = (Object[])it3.next();
			System.out.println(obj[0]+"  "+obj[1]);
		}
		
		/*// If we call addScalar() method then that query object is called scalar query object.
		SQLQuery qry = session.createSQLQuery("select EMPLOYEEID, EMPLOYEENAME  from EMPLOYEE");
		qry.addScalar("EMPLOYEEID",Hibernate.iNTEGER);
		qry.addScalar("EMPLOYEENAME",Hibernate.STRING);
		List list = qry.list();*/

		session.close();
		factory.close();
	}
}
