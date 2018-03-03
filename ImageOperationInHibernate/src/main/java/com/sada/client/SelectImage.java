package com.sada.client;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.sada.Model.Company;
public class SelectImage {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		Object o = session.load(Company.class, 111);
		Company c = (Company)o;
		Blob blb = c.getImage();
		try {
			InputStream in = blb.getBinaryStream();
			FileOutputStream fos= new FileOutputStream("G:\\Hibernate Workspace\\ImageOperationInHibernate\\src\\main\\resources\\downloadimg.png");
			int k;
			while((k=in.read())!=-1){
				fos.write(k);
			}
			fos.close();
			System.out.println("photo retrived successfully");
			session.close();
			factory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
