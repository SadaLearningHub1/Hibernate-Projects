package com.sadalearninghub.MyFisrstApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration conf = new Configuration().configure("hibernate.cfg.xml");
    	SessionFactory factory = conf.buildSessionFactory();
    	Session session = factory.openSession();
    	if(session != null) {
    		System.out.println( "Hello World!" );
    	}
        
    }
}
