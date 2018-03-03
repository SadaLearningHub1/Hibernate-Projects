package com.sada.client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Employee;
public class CriteriaAPIClient {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		//Read Partial object using Criteria API
		Criteria crit1 = session.createCriteria(Employee.class);
		Projection p1 = Projections.property("employeeId");
		Projection p2 = Projections.property("employeeName");
		ProjectionList  plist = Projections.projectionList();
		plist.add(p1);
		plist.add(p2);
		crit1.setProjection(plist);
		List list = crit1.list();
		Iterator it = list.iterator();
		while(it.hasNext()){
			Object  obj[] = (Object[])it.next();
			System.out.println(obj[0]+"    "+obj[1]);
		}
		
		//Read Single object using Criteria API
		Criteria crit2 = session.createCriteria(Employee.class);
		Projection p3 = Projections.property("employeeName");
		crit2.setProjection(p3);
		List list1 = crit2.list();
		Iterator it1 = list1.iterator();
		while(it1.hasNext()){
			String  str = (String)it1.next();
			System.out.println("Employee name: "+str);
		}
		
		
		//Find Sum and Avarage of Employee salary using Criteria API
		Criteria crit3 = session.createCriteria(Employee.class);
		Projection p4 = Projections.sum("employeeSal");
		Projection p5 = Projections.avg("employeeSal");
		ProjectionList  plist1 = Projections.projectionList();
		plist1.add(p4);
		plist1.add(p5);
		crit3.setProjection(plist1);
		List list2 = crit3.list();
		Object obj[] = (Object[])list2.get(0);
		System.out.println("sum: " +obj[0]);
		System.out.println("Average : "+obj[1]);
		
		session.close();
		factory.close();
	}
}
