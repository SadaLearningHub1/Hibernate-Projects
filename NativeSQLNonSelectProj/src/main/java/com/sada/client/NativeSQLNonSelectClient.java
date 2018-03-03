package com.sada.client;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
public class NativeSQLNonSelectClient {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();

		SQLQuery qry = session.createSQLQuery("update EMPLOYEE set EMPLOYEESAL=? Where EMPLOYEEID=?");
		qry.setParameter(0,9999);
		qry.setParameter(1,1);
		Transaction tx = session.beginTransaction();
		int i = qry.executeUpdate();
		tx.commit();

		session.close();
		factory.close();
	}
}
