package com.sada.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Company;
public class InsertImage {
	public static void main(String[] args) throws IOException {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		File file = new File("G:\\Hibernate Workspace\\ImageOperationInHibernate\\src\\main\\resources\\Picture1.png");
		int length = (int)file.length();
		byte b[] = new byte[length];
		FileInputStream fis = new FileInputStream(file);
		fis.read(b);
		
		Blob photo = Hibernate.getLobCreator(session).createBlob(b);
		Company c = new Company();
		c.setCompanyId(111);
		c.setImage(photo);
		
		
		Transaction tx = session.beginTransaction();
		session.save(c);
		
		tx.commit();
		
		session.close();
		factory.close();
	}
}
