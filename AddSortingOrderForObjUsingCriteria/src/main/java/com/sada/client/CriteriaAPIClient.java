package com.sada.client;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
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
		
		Criteria crit = session.createCriteria(Employee.class);
		Order o =Order.asc("employeeSal");
		crit.addOrder(o);
		List list = crit.list();
		Iterator it = list.iterator();
		while(it.hasNext()){
			Employee  e = (Employee)it.next();
			System.out.println("Employee Id: "+e.getEmployeeId());
			System.out.println("EmployeeName: "+e.getEmployeeName());
			System.out.println("Employee sal: "+e.getEmployeeSal());
			System.out.println("Department number:"+e.getDeptNumber());
			System.out.println("============================================");
		}

		session.close();
		factory.close();
	}
}
